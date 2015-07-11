var fs = require("fs");
var async = require("async");
var path = require('path');
var Promise = require('es6-promise').Promise;

var Converter = require("csvtojson").Converter;
var PRs = require('./PRsService');

var DEPLOYS_FILEPATH = path.join(__dirname, '../csv/deploys.csv')

function getPRSforDeploys(deploys) {
  var promises = deploys.deploy_list.map(function (deploy) {
    var prs = deploy.prs.split(' ')
    return new Promise(function (resolve, reject) {
      PRs.findPRsbyIDs(prs, resolve)
    }).then(function (prs) {
      deploy.prs = prs
      return deploy
    })
  })

  return Promise.all(promises).then(function (results) {
    return deploys
  })
}

function readDeploysFile(callback) {
  var fileStream = fs.createReadStream(DEPLOYS_FILEPATH);
  var converter = new Converter({constructResult:true});

  converter.on("end_parsed", function (data) {
    var deploys = {}

    deploys.deploy_list = data
    deploys.count = data.length

    getPRSforDeploys(deploys).then(callback)
  })

  fileStream.pipe(converter);
}

exports.getAllDeploys = function(callback) {
  readDeploysFile(callback)
}