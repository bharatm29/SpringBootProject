# Spring Boot Practice Projects

---

This repository contains a collection of APIs I have made while learning Spring Boot. I have organised different project in different branches.

--- 
### _List of APIs I have made_[^1]
* **Movie Catalog API**
* **Anime Catalog API**
* **Games API**
* **Space API**
* **Movie API**
* **MealRecipeAPI**

---
### Movie Catalog API
Using this REST API a user can rate a particular set of movies and store it under an ID similar to IMDb.

It is my first API which follows [Microservice Architecture](https://microservices.io).

It implements the [CircuitBreaker Design Pattern](https://learn.microsoft.com/en-us/azure/architecture/patterns/circuit-breaker) using [Resilience4j](https://resilience4j.readme.io/docs). 

Microservices communicate with each other through [Service Discovery](https://www.baeldung.com/cs/service-discovery-microservices) implemented using [Eureka](https://spring.io/guides/gs/service-registration-and-discovery/).

It calls [TMDB](https://www.themoviedb.org) to fetch movie information.

---

### Anime Catalog API
Similar to the __Movie Catalog API__, we can store a particular set of animes under an email address.

It has strict JWT security implemented using __Spring Security__.

It uses __MySQL__ database to store the user data and __MongoDB atlas__ to store the anime data associated with an user email.

It leverages Service Discovery, Circuit breaker pattern and Java persistence API.

It makes calls to a locally running __express__ server to get information regarding animes which is available on github, [here](https://github.com/riimuru/gogoanime-api).

---

### Games API
This REST API gives information about a game along with its current rating and ranking through various endpoints.

It is the first _REST API_ I have created from scratch immediately after completing the [Spring Boot tutorial](https://www.youtube.com/playlist?list=PLqq-6Pq4lTTbx8p2oCgcAQGQyqN8XeA1x) by [Java Brains](https://www.youtube.com/@Java.Brains) on youtube.

It leverages the standard [MVC design pattern](https://developer.mozilla.org/en-US/docs/Glossary/MVC). 

It utilizes [Batch Processing](https://spring.io/guides/gs/batch-processing/) to populate the embedded database _([h2](https://www.baeldung.com/spring-boot-h2-database))_ with data read from the [games.csv](src/main/resources/gamesupdated.csv).

The [games.csv](src/main/resources/gamesupdated.csv) contains a list of video games dating from 1980 to 2023 which is available at [Kaggle](https://www.kaggle.com/datasets/arnabchaki/popular-video-games-1980-2023).


---
### Space API
This REST API exposes endpoints which provides [Astronomy picture of the day](https://apod.nasa.gov/apod/astropix.html) and images which are available at [NASA image library](https://www.nasa.gov/multimedia/imagegallery/index.html) for an input date.

It calls publically available [NASA APIs](https://api.nasa.gov) to fetch the data.

It leverages [Thymeleaf](https://www.thymeleaf.org) to provide a simple frontend.

---
### Movie API
This API takes a JSON payload which contains the movie title along with its rating and stores it in an embedded database. The stored movie can be retrieved through an endpoint using a movie ID.

---
### MealRecipe API
A very simple API which provides recipes for meal through various endpoints.

---

[^1]: There is also Microservice Level1 and 2 which are tutorial API.
