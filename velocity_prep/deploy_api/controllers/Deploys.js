'use strict';

var url = require('url');
var deploys = require('./DeploysService');


var deployCallback = function (req, res, next) {
  return function (result) {
    if (typeof result !== 'undefined') {
      res.setHeader('Content-Type', 'application/json');
      res.end(JSON.stringify(result || {}, null, 2));
    }
    else {
      res.status(404).end();
    }
  }
}

module.exports.getAllDeploys = function getAllDeploys (req, res, next) {
  deploys.getAllDeploys(deployCallback(req, res, next));
};

module.exports.findDeploysbyDate = function findDeploysbyDate (req, res, next) {
  var start = req.query.start;
  var end = req.query.end;

  deploys.findDeploysbyDate(start, end, deployCallback(req, res, next));
};

module.exports.findDeploysByRepo = function findDeploysByRepo (req, res, next) {
  var repo = req.params.repo;
  deploys.findDeploysByRepo(repo, deployCallback(req, res, next));
};

module.exports.findDeploysByVersion = function findDeploysByVersion (req, res, next) {
  var repo = req.params.repo;
  var ver = req.params.ver;

  deploys.findDeploysByVersion(repo, ver, deployCallback(req, res, next));
};

module.exports.findDeploysByRepoAndDate = function findDeploysByRepoAndDate (req, res, next) {
  var repo = req.params.repo;
  var start = req.query.start;
  var end = req.query.end;
  //deploys.findDeploysByRepo(repo, deployCallback(req, res, next));
  deploys.findDeploysByRepoAndDate(repo, start, end, deployCallback(req, res, next));
};

