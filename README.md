Eureka server: http://localhost:8761/

ItemCatalog swagger: http://localhost:8088/swagger-ui.html
ItemCatalog actuator: http://localhost:8088/actuator

Person swagger: http://localhost:8089/swagger-ui.html
Person actuator: http://localhost:8089/actuator

There are two microservices projects: ItemCatalog and Person.

Person is responsible for managing users and integrate with external resources for address data using Feign Client.

ItemCatalog is responsible for registering generic items where each item has a Person, so this microservice integrates with Person microservice using Feign Client.

**TODO**
* Refactor the current code to fix the use of Data classes and put the classes to the right place using DDD.
* Configure and testing Circuit Breaker with Hystrix
* Configure and testing Load Balancing using Zuul
* Test Service Discovery using the configured Eureka
* Test the Actuator
* Fix Swagger
* Create unit and integration tests