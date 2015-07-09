'use strict';

var url = require('url');


var Deploys = require('./DeploysService');


module.exports.deploysGet = function deploysGet (req, res, next) {
  

  var result = Deploys.deploysGet();

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findDeploysbyDate = function findDeploysbyDate (req, res, next) {
  var start = req.swagger.params['start'].value;
  var end = req.swagger.params['end'].value;
  

  var result = Deploys.findDeploysbyDate(start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findDeploysByRepo = function findDeploysByRepo (req, res, next) {
  var repo = req.swagger.params['repo'].value;
  

  var result = Deploys.findDeploysByRepo(repo);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findDeploysByRepoAndDate = function findDeploysByRepoAndDate (req, res, next) {
  var repo = req.swagger.params['repo'].value;
  var start = req.swagger.params['start'].value;
  var end = req.swagger.params['end'].value;
  

  var result = Deploys.findDeploysByRepoAndDate(repo, start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findDeploysByVersion = function findDeploysByVersion (req, res, next) {
  var repo = req.swagger.params['repo'].value;
  var version = req.swagger.params['version'].value;
  

  var result = Deploys.findDeploysByVersion(repo, version);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
