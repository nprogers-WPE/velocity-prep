'use strict';

exports.getAllCRs = function() {

  var examples = {};
  
  examples['application/json'] = {
  "cr_list" : [ {
    "cr_author" : "aeiou",
    "cr_id" : 123,
    "cr_title" : "aeiou",
    "cr_date" : "aeiou",
    "cr_desc" : "aeiou"
  } ],
  "count" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findCRsbyDate = function(start, end) {

  var examples = {};
  
  examples['application/json'] = {
  "cr_list" : [ {
    "cr_author" : "aeiou",
    "cr_id" : 123,
    "cr_title" : "aeiou",
    "cr_date" : "aeiou",
    "cr_desc" : "aeiou"
  } ],
  "count" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findCRbyID = function(crId) {

  var examples = {};
  
  examples['application/json'] = {
  "cr_author" : "aeiou",
  "cr_id" : 123,
  "cr_title" : "aeiou",
  "cr_date" : "aeiou",
  "cr_desc" : "aeiou"
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
