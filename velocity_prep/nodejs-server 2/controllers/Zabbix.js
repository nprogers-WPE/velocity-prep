'use strict';

var url = require('url');


var Zabbix = require('./ZabbixService');


module.exports.getAllZabbixErrors = function getAllZabbixErrors (req, res, next) {
  

  var result = Zabbix.getAllZabbixErrors();

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findZabbixbyDate = function findZabbixbyDate (req, res, next) {
  var start = req.swagger.params['start'].value;
  var end = req.swagger.params['end'].value;
  

  var result = Zabbix.findZabbixbyDate(start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findZabbixbyID = function findZabbixbyID (req, res, next) {
  var zabbixId = req.swagger.params['zabbix_id'].value;
  

  var result = Zabbix.findZabbixbyID(zabbixId);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
