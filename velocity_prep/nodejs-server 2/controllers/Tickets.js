'use strict';

var url = require('url');


var Tickets = require('./TicketsService');


module.exports.getAllTickets = function getAllTickets (req, res, next) {
  

  var result = Tickets.getAllTickets();

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findTicketsbyDate = function findTicketsbyDate (req, res, next) {
  var start = req.swagger.params['start'].value;
  var end = req.swagger.params['end'].value;
  

  var result = Tickets.findTicketsbyDate(start, end);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};

module.exports.findTicketbyID = function findTicketbyID (req, res, next) {
  var ticketId = req.swagger.params['ticket_id'].value;
  

  var result = Tickets.findTicketbyID(ticketId);

  if(typeof result !== 'undefined') {
    res.setHeader('Content-Type', 'application/json');
    res.end(JSON.stringify(result || {}, null, 2));
  }
  else
    res.end();
};
