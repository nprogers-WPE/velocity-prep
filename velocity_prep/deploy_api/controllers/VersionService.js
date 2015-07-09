'use strict';

exports.findDeploysByVersion = function(repo, version) {

  var examples = {};
  
  examples['application/json'] = {
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
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
