'use strict';

var url = require('url');

var PRs = require('./PRsService');

var prCallback = function (req, res, next) {
  return function (result) {
    if(typeof result !== 'undefined') {
      res.setHeader('Content-Type', 'application/json');
      res.end(JSON.stringify(result || {}, null, 2));
    }
    else {
      res.status(404).end();
    }
  }
}

module.exports.getAllPRs = function getAllPRs (req, res, next) {
  PRs.getAllPRs(prCallback(req, res, next));
};

module.exports.findPRsbyDate = function findPRsbyDate (req, res, next) {
  var start = req.query.start;
  var end = req.query.end;

  PRs.findPRsbyDate(start, end, prCallback(req, res, next));
};

module.exports.findPRbyID = function findPRbyID (req, res, next) {
  var prId = req.params.id;
  PRs.findPRbyID(prId, prCallback(req, res, next));
};
