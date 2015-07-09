'use strict';

var url = require('url');

var CRs = require('./CRsService');

var crCallback = function (req, res, next) {
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

module.exports.getAllCRs = function getAllCRs (req, res, next) {
  CRs.getAllCRs(crCallback(req, res, next));
};

module.exports.findCRsbyDate = function findCRsbyDate (req, res, next) {
  var start = req.query.start;
  var end = req.query.end;

  CRs.findCRsbyDate(start, end, crCallback(req, res, next));
};

module.exports.findCRbyID = function findCRbyID (req, res, next) {
  var crId = req.params.id;
  CRs.findCRbyID(crId, crCallback(req, res, next));
};
