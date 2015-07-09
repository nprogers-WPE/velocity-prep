'use strict';

exports.findDeploysByRepo = function(repo) {

  var examples = {};
  
  examples['application/json'] = {
  "count" : 123,
  "deploy_list" : [ {
    "prs" : {
      "pr_list" : [ {
        "pr_title" : "aeiou",
        "pr_desc" : "aeiou",
        "pr_id" : 123,
        "pr_date" : "aeiou",
        "pr_author" : "aeiou"
      } ],
      "count" : 123
    },
    "release_date" : "aeiou",
    "repo" : "aeiou",
    "version" : "aeiou"
  } ]
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findDeploysByRepoAndDate = function(repo, start, end) {

  var examples = {};
  
  examples['application/json'] = {
  "count" : 123,
  "deploy_list" : [ {
    "prs" : {
      "pr_list" : [ {
        "pr_title" : "aeiou",
        "pr_desc" : "aeiou",
        "pr_id" : 123,
        "pr_date" : "aeiou",
        "pr_author" : "aeiou"
      } ],
      "count" : 123
    },
    "release_date" : "aeiou",
    "repo" : "aeiou",
    "version" : "aeiou"
  } ]
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
