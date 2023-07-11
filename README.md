# This is my implementation for the Wix Kickstart home assignment #

### Tasks
The exam is split into two parts. The first part focuses on creating a basic server. You can implement this in *any* programming language you feel comfortable with. The second part involves creating a usable server.

#### Part (01) - Create a simple API that returns the tickets from the database
Take a look at the  data.json file - it contains 200 tickets. We would like you to create a simple API with a GET endpoint at /tickets.

#### Part (02) - Implement Filtering Functionality
Imagine that the database could eventually have millions of tickets. We need the ability to filter the returning requests on the server side.

1. Our product manager has asked to implement a search bar in the product that returns only tickets that match. You are responsible for the server-side implementation. Implement this functionality so that only tickets matching the text in the title will return.

2. Another useful implementation is to filter by time. Implement a filter that can receive from, to or both, and return tickets that match this criteria.​

3. Turns out that the search you implemented in section 1 is great, but sometimes it would be even better to search in all the text fields! (title, content and email). Please implement this filter.

### About My Solution
* I'm using Java 17.
* Using Maven for dependencies management.
* Build with Spring Boot (source from the spring-boot-starter-parent).
* Use Lombok for data use simplifying.

### Notes
The first commit is a full working program answering all the parts of the task.
To start the app, run the KickstartApplication class. This will enable querying the REST API on http://localhost:8080.

For Part (1) you might send an HTTP GET request to path http://localhost:8080/tickets

For Part(2):
1. Send an HTTP GET request to path http://localhost:8080/tickets/{title}
2. Send an HTTP POST request to path http://localhost:8080/tickets?from=FROM&to=TO . You may send them in any order or one of them.
3. Send an HTTP POST request to path http://localhost:8080/tickets?searchTerm=YOUR_SEARCH_TERM .

Part (2) section 3 still need a better handling for some special cases.