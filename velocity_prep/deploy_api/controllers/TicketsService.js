//Converter Class 
var fs = require("fs");
var Converter = require("csvtojson").Converter;

var TICKETS_FILEPATH = '/Users/natalie.rogers/velocity_prep/tickets.csv'

function readTicketsFile(callback) {
  var fileStream = fs.createReadStream(TICKETS_FILEPATH);
  var converter = new Converter({constructResult:true});

  converter.on("end_parsed", function (data) {
    var tickets = {}

    tickets.ticket_list = data
    tickets.count   = data.length

    callback(tickets)
  })

  fileStream.pipe(converter);
}

exports.getAllTickets = function(callback) {
  readTicketsFile(callback)
}

exports.findTicketsbyDate = function(start, end, callback) {
  start = Date.parse(start) || 0
  end   = Date.parse(end)   || Date.now()

  function isDateInRange(date) {
    return start <= date && date <= end
  }

  readTicketsFile(function (data) {
    data.ticket_list = data.ticket_list.filter(function (ticket) {
      return isDateInRange(Date.parse(ticket.ticket_date))
    })
    data.count = data.ticket_list.length

    callback(data)
  })  
}

exports.findTicketbyID = function(ticketId, callback) {
  readTicketsFile(function (data) {
    var ticketList = data.ticket_list
    var ticket = ticketList.filter(function (ticket) {
      return ticket.ticket_id == ticketId
    })[0]

    callback(ticket)
  })
}
