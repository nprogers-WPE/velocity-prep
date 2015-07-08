#!/usr/bin/python

from faker.factory import Factory
import csv 
import sys
import random
import datetime as DT

# TODO: It would be cool if these had links to randomly generated fake PR's on a WP site's pages

def writeTo_csv(fake):
    authors = generateAuthorList(15)
    pr_list = createPrs(authors)
    createDeploys(pr_list)
    createCrs(authors)
    createTickets()
    createZabbix()

def generateAuthorList(num_authors):
    authors = []
    for _ in range(num_authors):
        authors.append(fake.name())
    return authors

def createPrs(authors):
    pr_list = []
    pr_date_id = 1
    with open('pr_list.csv', 'wb') as csvfile:
        write_to_csv = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        write_to_csv.writerow(['pr_id,', 'pr_author,', 'pr_title,', 'pr_date,', 'pr_desc,'])
        for _ in range(100):
            pr_id = fake.random_int(min=100, max=99999)
            pr_author = random.choice(authors)
            pr_title = "PR-" + str(pr_id) + ": Did stuff to something"
            pr_date_change = 100 - pr_date_id
            start_date = "-{}d".format(pr_date_change)
            end_date = "-{}d".format(pr_date_change - 10)
            pr_date = fake.date_time_between(start_date=start_date, end_date=end_date)
            pr_desc = "This PR did some stuff and added integration tests to make sure it works properly"
            write_to_csv.writerow((pr_id, pr_author, pr_title, pr_date, pr_desc))
            pr_properties = [pr_id, pr_author, pr_title, pr_date, pr_desc]
            pr_list.append(pr_properties)
            # Add Logging
    return pr_list

def createDeploys(full_pr_list):    
    with open('deploy_list.csv', 'wb') as csvfile:
        subversion = 1
        pr_min = 1
        pr_max = 10
        today = DT.date.today()
        repos = ['nas2','soapbox','cm','deltas','snappyshot']
        write_to_csv = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        write_to_csv.writerow(['version,', 'release_date,', 'repo,', 'prs,'])
        for _ in range(10):
            # TODO: Do we need a count?
            prs = {'count': 10, "pr_list":[]}
            version = "1." + str(subversion) + ".0"
            description = "Deploy"

            # Figure out the correct release date
            date_delta = 100 - pr_max
            release_date = today - DT.timedelta(days=date_delta)
            repo = random.choice(repos)

            # Get range of prs from list
            prs["pr_list"].append(full_pr_list[pr_min:pr_max])
            pr_min += 10
            pr_max += 10
            subversion += 1
            write_to_csv.writerow((version, release_date, repo, prs))
            # Add Logging

def createCrs(authors):
    with open('cr_list.csv', 'wb') as csvfile:
        write_to_csv = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        write_to_csv.writerow(['cr_id,', 'cr_author,', 'cr_title,', 'cr_date,', 'cr_desc,'])
        for _ in range(100):
            cr_author = random.choice(authors)
            cr_id = fake.random_int(min=100, max=99999)
            cr_title = "CR-" + str(cr_id) + ": Fixed bug in code that was breaking things"
            cr_date = fake.date_time_between(start_date="-100d", end_date="now")
            cr_desc = "This PR did some stuff and added integration tests to make sure it works properly"
            write_to_csv.writerow((cr_id, cr_author, cr_title, cr_date, cr_desc))
            # TODO: Add logging

def createTickets():
    with open('tickets_list.csv', 'wb') as csvfile:
        write_to_csv = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        write_to_csv.writerow(['ticket_id,', 'ticket_date,', 'ticket_desc,'])
        for _ in range(1000):
            ticket_id = fake.random_int(min=100, max=99999)
            ticket_date = fake.date_time_between(start_date="-100d", end_date="now")
            ticket_desc = "Customer site returning a 500 instead of site content. Site has been down for 15 minutes."
            write_to_csv.writerow((ticket_id, ticket_date, ticket_desc))
        # Add spikes in tickets every 10 days
        # TODO: Add logging

def createZabbix():
    with open('zabbix_list.csv', 'wb') as csvfile:
        write_to_csv = csv.writer(csvfile, delimiter=',', quotechar='"', quoting=csv.QUOTE_MINIMAL)
        write_to_csv.writerow(['zabbix_id,', 'zabbix_date,', 'zabbix_desc,'])
        for _ in range(1000):
            zabbix_id = fake.random_int(min=100, max=99999)
            zabbix_date = fake.date_time_between(start_date="-100d", end_date="now")
            server_number = random.randint(1000,99999)
            zabbix_desc = "Server number {} is down.".format(server_number)
            write_to_csv.writerow((zabbix_id, zabbix_date, zabbix_desc))
        # Add spikes in tickets every 10 days
        # TODO: Add logging

if __name__ == "__main__":
    fake = Factory.create('en_US')
    writeTo_csv(fake)
