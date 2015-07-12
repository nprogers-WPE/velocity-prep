//Converter Class
var fs = require("fs");
var Converter = require("csvtojson").Converter;
var path = require('path');


var PRS_FILEPATH = path.join(__dirname, '../csv/prs.csv')

function readPRsFile(callback) {
  var fileStream = fs.createReadStream(PRS_FILEPATH);
  var converter = new Converter({constructResult:true});

  converter.on("end_parsed", function (data) {
    var prs = {}

    prs.pr_list = data
    prs.count   = data.length

    callback(prs)
  })

  fileStream.pipe(converter);
}

exports.getAllPRs = function(callback) {
  readPRsFile(callback)
}

exports.findPRsbyDate = function(start, end, callback) {
  start = Date.parse(start) || 0
  end   = Date.parse(end)   || Date.now()

  function isDateInRange(date) {
    return start <= date && date <= end
  }

  readPRsFile(function (data) {
    data.pr_list = data.pr_list.filter(function (pr) {
      return isDateInRange(Date.parse(pr.pr_date))
    })
    data.count = data.pr_list.length

    callback(data)
  })
}

exports.findPRbyID = function(prId, callback) {
  findPRsbyIDs([prId], function (data) {
    callback(data.pr_list[0])
  })
}

var findPRsbyIDs = exports.findPRsbyIDs = function (prIds, callback) {
  prIds = prIds.map(function (pr) { return +pr })
  readPRsFile(function (data) {
    data.pr_list = data.pr_list.filter(function (pr) {
      return ~prIds.indexOf(pr.pr_id)
    })

    callback(data)
  })
}