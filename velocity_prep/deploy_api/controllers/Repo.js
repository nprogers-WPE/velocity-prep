'use strict';

var url = require('url');


var Repo = require('./RepoService');


module.exports.findDeploysByRepo = function findDeploysByRepo (req, res, next) {
  var repo = req.swagger.params['repo'].value;
  

  var result = Repo.findDeploysByRepo(repo);

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
  

  var result = Repo.findDeploysByRepoAndDate(repo, start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
