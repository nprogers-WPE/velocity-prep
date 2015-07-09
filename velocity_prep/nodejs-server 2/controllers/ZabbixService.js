'use strict';

exports.getAllZabbixErrors = function() {

  var examples = {};
  
  examples['application/json'] = {
  "zabbix_list" : [ {
    "zabbix_date" : "aeiou",
    "zabbix_id" : 123,
    "zabbix_desc" : "aeiou"
  } ],
  "count" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findZabbixbyDate = function(start, end) {

  var examples = {};
  
  examples['application/json'] = {
  "zabbix_list" : [ {
    "zabbix_date" : "aeiou",
    "zabbix_id" : 123,
    "zabbix_desc" : "aeiou"
  } ],
  "count" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findZabbixbyID = function(zabbixId) {

  var examples = {};
  
  examples['application/json'] = {
  "zabbix_date" : "aeiou",
  "zabbix_id" : 123,
  "zabbix_desc" : "aeiou"
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
