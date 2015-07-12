var express = require('express')
var app 	= express()

var controllers = require('./controllers')

var PORT = process.env.PORT || 3000

app.get('/crs/', controllers.crs.getAllCRs)
app.get('/crs/list', controllers.crs.findCRsbyDate)
app.get('/crs/:id', controllers.crs.findCRbyID)

app.get('/prs/', controllers.prs.getAllPRs)
app.get('/prs/list', controllers.prs.findPRsbyDate)
app.get('/prs/:id', controllers.prs.findPRbyID)

app.get('/tickets/', controllers.tickets.getAllTickets)
app.get('/tickets/list', controllers.tickets.findTicketsbyDate)
app.get('/tickets/:id', controllers.tickets.findTicketbyID)

app.get('/zabbix/', controllers.zabbix.getAllZabbix)
app.get('/zabbix/list', controllers.zabbix.findZabbixbyDate)
app.get('/zabbix/:id', controllers.zabbix.findZabbixbyID)

app.get('/deploys/', controllers.deploys.getAllDeploys)
app.get('/deploys/list', controllers.deploys.findDeploysbyDate)
app.get('/deploys/:repo', controllers.deploys.findDeploysByRepo)
app.get('/deploys/:repo/list', controllers.deploys.findDeploysByRepoAndDate)
app.get('/deploys/:repo/:ver', controllers.deploys.findDeploysByVersion)



var server = app.listen(PORT, function () {
	var host = server.address().address;
  var port = server.address().port;

  console.log('Example app listening at http://%s:%s', host, port);
})