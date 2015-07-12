'use strict';

var url = require('url');


var Version = require('./VersionService');


module.exports.findDeploysByVersion = function findDeploysByVersion (req, res, next) {
  var repo = req.swagger.params['repo'].value;
  var version = req.swagger.params['version'].value;
  

  var result = Version.findDeploysByVersion(repo, version);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
