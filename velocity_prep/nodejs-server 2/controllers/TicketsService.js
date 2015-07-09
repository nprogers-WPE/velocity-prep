'use strict';

exports.getAllTickets = function() {

  var examples = {};
  
  examples['application/json'] = {
  "count" : 123,
  "ticket_list" : [ {
    "ticket_desc" : "aeiou",
    "ticket_date" : "aeiou",
    "ticket_id" : 123
  } ]
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findTicketsbyDate = function(start, end) {

  var examples = {};
  
  examples['application/json'] = {
  "count" : 123,
  "ticket_list" : [ {
    "ticket_desc" : "aeiou",
    "ticket_date" : "aeiou",
    "ticket_id" : 123
  } ]
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
exports.findTicketbyID = function(ticketId) {

  var examples = {};
  
  examples['application/json'] = {
  "ticket_desc" : "aeiou",
  "ticket_date" : "aeiou",
  "ticket_id" : 123
};
  

  
  if(Object.keys(examples).length > 0)
    return examples[Object.keys(examples)[0]];
  
}
