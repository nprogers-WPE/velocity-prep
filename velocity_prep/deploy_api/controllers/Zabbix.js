'use strict';

var url = require('url');

var Zabbix = require('./ZabbixService');

var zabbixCallback = function (req, res, next) {
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

module.exports.getAllZabbix = function getAllZabbix (req, res, next) {
  Zabbix.getAllZabbix(zabbixCallback(req, res, next));
};

module.exports.findZabbixbyDate = function findZabbixbyDate (req, res, next) {
  var start = req.query.start;
  var end = req.query.end;

  Zabbix.findZabbixbyDate(start, end, zabbixCallback(req, res, next));
};

module.exports.findZabbixbyID = function findZabbixbyID (req, res, next) {
  console.log("you are here!")
  var zabbixId = req.params.id;
  Zabbix.findZabbixbyID(zabbixId, zabbixCallback(req, res, next));
};
