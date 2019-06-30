# Instructions to use the application:

## Angular application
	• the application run in port no 4200
	• Follow the UI to make a search about flights to data store


## Spring boot application

The application has two data server, first is flights.json file stored in the application and the second is mysql server

The angular application fetch data from POST request at "http://localhost:8080/flightsjson/search" which gets data from flights.json file

The restful service is also available through mysql database. (not used by front-end application). To test the restful services, follow the following instructions:

	• put you database information in application.properties - username, password and url
	• open your database and create a schema uniteddb
	• the database is then populated with few data using embedded data.sql file in the application
	

