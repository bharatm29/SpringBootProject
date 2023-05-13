# Spring Boot Practice Projects

---

This is a Repository containing all the API I have made using Spring Boot.

--- 
### _List of APIs I have made_[^1]
 * **Movie Catalog API**
* **Games API**
* **Space API**
* **Movie API**

---
### Games API
This REST API gives information about a game along with its current rating and ranking on query.

It is the first _REST API_ I have created from scratch immediately after completing the [Spring Boot tutorial](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x) by [Java Brains](https://www.youtube.com/@Java.Brains) on youtube.

It uses the standard [MVC design pattern](https://developer.mozilla.org/en-US/docs/Glossary/MVC). 

It uses [Batch Processing](https://spring.io/guides/gs/batch-processing/) to populate the embedded database _([h2](https://www.baeldung.com/spring-boot-h2-database))_ with the data read from the [games.csv](src/main/resources/gamesupdated.csv).

The [games.csv](src/main/resources/gamesupdated.csv) contains a list of video games dating from 1980 to 2023 which is available at [Kaggle](https://www.kaggle.com/datasets/arnabchaki/popular-video-games-1980-2023).

---
### Movie API
This is an extremely simple REST API which takes a JSON payload and stores the movie title and rating in an embedded database. The movie can be retrieved by an endpoint using a movie ID.

---
### Space API
This REST API provides the [Astronomy picture of the day](https://apod.nasa.gov/apod/astropix.html) and images which are available at [NASA image library](https://www.nasa.gov/multimedia/imagegallery/index.html).

It calls publically available [NASA APIs](https://api.nasa.gov) to fetch the data.
It also implements the [CircuitBreaker Design Pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker).

---
### Movie Catalog API
Using this REST API a user can rate a particular set of movies and store it under an ID similar to IMDb.

It is my first API which follows [Microservice Architecture](https://microservices.io).

It implements the [CircuitBreaker Design Pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker) using [Resilience4j](https://resilience4j.readme.io/docs). 

Microservices communicate with each other through [Service Discovery](https://www.baeldung.com/cs/service-discovery-microservices) implemented using [Eureka](https://spring.io/guides/gs/service-registration-and-discovery/).

---
[^1]: There is also Microservice Level1 and 2 which are tutorial API.
