'use strict';

var url = require('url');


var CRs = require('./CRsService');


module.exports.getAllCRs = function getAllCRs (req, res, next) {
  

  var result = CRs.getAllCRs();

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findCRsbyDate = function findCRsbyDate (req, res, next) {
  var start = req.swagger.params['start'].value;
  var end = req.swagger.params['end'].value;
  

  var result = CRs.findCRsbyDate(start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findCRbyID = function findCRbyID (req, res, next) {
  var crId = req.swagger.params['cr_id'].value;
  

  var result = CRs.findCRbyID(crId);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
