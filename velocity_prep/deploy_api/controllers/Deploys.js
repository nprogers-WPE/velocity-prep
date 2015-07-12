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
