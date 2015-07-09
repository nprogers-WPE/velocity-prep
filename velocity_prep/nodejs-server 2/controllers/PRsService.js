'use strict';

exports.getAllPRs = function() {

  var examples = {};
  
  examples['application/json'] = {
  "pr_list" : [ {
    "pr_title" : "aeiou",
    "pr_desc" : "aeiou",
    "pr_id" : 123,
    "pr_date" : "aeiou",
    "pr_author" : "aeiou"
  } ],
  "count" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findPRsbyDate = function(start, end) {

  var examples = {};
  
  examples['application/json'] = {
  "pr_list" : [ {
    "pr_title" : "aeiou",
    "pr_desc" : "aeiou",
    "pr_id" : 123,
    "pr_date" : "aeiou",
    "pr_author" : "aeiou"
  } ],
  "count" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findPRbyID = function(prId) {

  var examples = {};
  
  examples['application/json'] = {
  "pr_title" : "aeiou",
  "pr_desc" : "aeiou",
  "pr_id" : 123,
  "pr_date" : "aeiou",
  "pr_author" : "aeiou"
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
