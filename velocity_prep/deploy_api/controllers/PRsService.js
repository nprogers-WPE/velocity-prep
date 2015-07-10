//Converter Class 
var fs = require("fs");
var Converter = require("csvtojson").Converter;

var PRS_FILEPATH = '/Users/natalie.rogers/velocity_prep/prs.csv'

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
  readPRsFile(function (data) {
    var prList = data.pr_list
    var pr = prList.filter(function (pr) {
      return pr.pr_id == prId
    })[0]

    callback(pr)
  })
}