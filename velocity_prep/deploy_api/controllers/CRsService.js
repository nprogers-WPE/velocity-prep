//Converter Class 
var fs = require("fs");
var Converter = require("csvtojson").Converter;
var path = require('path')

var CRS_FILEPATH = path.join(__dirname, '../csv/crs.csv')

function readCRsFile(callback) {
  var fileStream = fs.createReadStream(CRS_FILEPATH);
  var converter = new Converter({constructResult:true});

  converter.on("end_parsed", function (data) {
    var crs = {}

    crs.cr_list = data
    crs.count   = data.length

    callback(crs)
  })

  fileStream.pipe(converter);
}

exports.getAllCRs = function(callback) {
  readCRsFile(callback)
}

exports.findCRsbyDate = function(start, end, callback) {
  console.log('start param:', start)
  start = Date.parse(start) || 0
  end   = Date.parse(end)   || Date.now()

  function isDateInRange(date) {
    console.log("start:", start)
    console.log("date:", date)
    console.log("end:", end)
    return start <= date && date <= end
  }

  readCRsFile(function (data) {
    data.cr_list = data.cr_list.filter(function (cr) {
      return isDateInRange(Date.parse(cr.cr_date))
    })
    data.count = data.cr_list.length

    callback(data)
  })  
}

exports.findCRbyID = function(crId, callback) {
  readCRsFile(function (data) {
    var crList = data.cr_list
    var cr = crList.filter(function (cr) {
      return cr.cr_id == crId
    })[0]

    callback(cr)
  })
}
