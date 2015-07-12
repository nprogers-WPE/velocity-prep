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

exports.findDeploysbyDate = function(start, end, callback) {
  start = Date.parse(start) || 0
  end   = Date.parse(end)   || Date.now()

  function isDateInRange(date) {
    return start <= date && date <= end
  }

  readDeploysFile(function (data) {
    data.deploy_list = data.deploy_list.filter(function (one_deploy) {
      return isDateInRange(Date.parse(one_deploy.release_date))
    })
    data.count = data.deploy_list.length

    callback(data)
  })  
}

exports.findDeploysByRepo = function(repo, callback) {
  readDeploysFile(function (data) {
    data.deploy_list= data.deploy_list.filter(function (one_deploy) {
      return one_deploy.repo == repo
    })
    data.count = data.deploy_list.length

    callback(data)
  })
}


exports.findDeploysByVersion = function(repo, ver, callback) {
  readDeploysFile(function (data) {
    d_list = data.deploy_list
    deploy= d_list.filter(function (one_deploy) {
      return one_deploy.repo == repo && one_deploy.version == ver
    })[0]

    callback(deploy)
  })
}

exports.findDeploysByRepoAndDate = function(repo, start, end, callback) {
  start = Date.parse(start) || 0
  end   = Date.parse(end)   || Date.now()

  function isDateInRangeRepo(date, d_repo) {
    return start <= date && date <= end && d_repo == repo
  }

  readDeploysFile(function (data) {
    data.deploy_list = data.deploy_list.filter(function (one_deploy) {
      return isDateInRangeRepo(Date.parse(one_deploy.release_date), one_deploy.repo) 
    })
    data.count = data.deploy_list.length

    callback(data)
  })  

}