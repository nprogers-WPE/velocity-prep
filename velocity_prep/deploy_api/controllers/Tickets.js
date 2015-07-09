'use strict';

var url = require('url');

var Tickets = require('./TicketsService');

var ticketCallback = function (req, res, next) {
  return function (result) {
    if(typeof result !== 'undefined') {
      res.setHeader('Content-Type', 'application/json');
      res.end(JSON.stringify(result || {}, null, 2));
    }
    else {
      res.status(404).end();
    }
  }
}

module.exports.getAllTickets = function getAllTickets (req, res, next) {
  Tickets.getAllTickets(ticketCallback(req, res, next));
};

module.exports.findTicketsbyDate = function findTicketsbyDate (req, res, next) {
  var start = req.query.start;
  var end = req.query.end;

  Tickets.findTicketsbyDate(start, end, ticketCallback(req, res, next));
};

module.exports.findTicketbyID = function findTicketbyID (req, res, next) {
  var ticketId = req.params.id;
  Tickets.findTicketbyID(ticketId, ticketCallback(req, res, next));
};
