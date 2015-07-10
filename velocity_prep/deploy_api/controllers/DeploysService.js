var fs = require("fs");
var async = require("async");
var path = require('path');
var Promise = require('es6-promise').Promise;

var Converter = require("csvtojson").Converter;
var PRs = require('./PRsService');

var DEPLOYS_FILEPATH = path.join(__dirname, '../csv/deploys.csv')

function prCallback(pr_list){
  console.log("current list", pr_list)
  return function(data){
    console.log("current data", data)
    pr_list.push(data)
  }
}
function logit(string, data){
  console.log(string, data)
}


function findPR(pr_id) {
    var ret;
    setTimeout
    PRs.findPRbyID(pr_id, function(data){
      logit("findPRbyID", data)
      ret = data
    })
    setTimeout( function (){
      logit("i am returning this", ret)
      return ret
    }, 2000)
    
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
    for (var i = 0; i < prs.length; i++){
      pr = findPR(prs[i]);
      console.log("pushing pr to list", pr)
      pr_list.push(pr)
    }
    console.log(pr_list)

    
    //async.map(findPR(pr_list), function (err, stuff){ return stuff});
    //console.log("pr_list",pr_list)

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