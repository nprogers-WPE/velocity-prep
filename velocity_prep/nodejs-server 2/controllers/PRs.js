'use strict';

var url = require('url');


var PRs = require('./PRsService');


module.exports.getAllPRs = function getAllPRs (req, res, next) {
  

  var result = PRs.getAllPRs();

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findPRsbyDate = function findPRsbyDate (req, res, next) {
  var start = req.swagger.params['start'].value;
  var end = req.swagger.params['end'].value;
  

  var result = PRs.findPRsbyDate(start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findPRbyID = function findPRbyID (req, res, next) {
  var prId = req.swagger.params['pr_id'].value;
  

  var result = PRs.findPRbyID(prId);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
