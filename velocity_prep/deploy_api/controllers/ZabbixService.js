//Converter Class 
var fs = require("fs");
var Converter = require("csvtojson").Converter;

var ZABBIX_FILEPATH = '/Users/natalie.rogers/velocity_prep/zabbix.csv'

function readZabbixFile(callback) {
  var fileStream = fs.createReadStream(ZABBIX_FILEPATH);
  var converter = new Converter({constructResult:true});

  converter.on("end_parsed", function (data) {
    var zabbix = {}

    zabbix.zabbix_list = data
    zabbix.count   = data.length

    callback(zabbix)
  })

  fileStream.pipe(converter);
}

exports.getAllZabbix = function(callback) {
  readZabbixFile(callback)
}

exports.findZabbixbyDate = function(start, end, callback) {
  start = Date.parse(start) || 0
  end   = Date.parse(end)   || Date.now()

  function isDateInRange(date) {
    return start <= date && date <= end
  }

  readZabbixFile(function (data) {
    data.zabbix_list = data.zabbix_list.filter(function (zabbix) {
      return isDateInRange(Date.parse(zabbix.ticket_date))
    })
    data.count = data.zabbix_list.length

    callback(data)
  })  
}

exports.findZabbixbyID = function(zabbixId, callback) {
  readZabbixFile(function (data) {
    var zabbixList = data.zabbix_list
    var zabbix = zabbixList.filter(function (zabbix) {
      return zabbix.zabbix_id == zabbixId
    })[0]

    callback(zabbix)
  })
}
