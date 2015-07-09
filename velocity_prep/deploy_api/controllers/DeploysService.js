var fs = require("fs");
var async = require("async");

var Converter = require("csvtojson").Converter;
var PRs = require('./PRsService');

var DEPLOYS_FILEPATH = '/Users/natalie.rogers/velocity_prep/deploys.csv'

function prCallback(pr_list){
  console.log("current list", pr_list)
  return function(data){
    console.log("current data", data)
    pr_list.push(data)
  }
}


var findPR = function(pr_list){
  return function(prID){
    PRs.findPRbyID(prID, prCallback(pr_list))
  }

}


function readDeploysFile(callback) {
  var fileStream = fs.createReadStream(DEPLOYS_FILEPATH);
  var converter = new Converter({constructResult:true});

  var deploy_list = {}
 
  converter.on("record_parsed", function(data){
    var prs = data.prs.split(" ")
    console.log("prs", prs)
    //console.log("test call", findPR('123'))
    pr_list = []
    async.map(findPR(pr_list), function (err, stuff){ return stuff});
    console.log("pr_list",pr_list)

  })

  converter.on("end_parsed", function (data) {
    


    var deploys = {}


    deploys.deploy_list = data
    deploys.count   = data.length

    callback(deploys)
  })

  fileStream.pipe(converter);
}

exports.getAllDeploys = function(callback) {
  readDeploysFile(callback)
}