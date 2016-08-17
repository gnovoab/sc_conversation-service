#Overview

This application provides the **conversation** related functionality and serves as one component. It defines the REST endpoints that are used to provide user functionality.

##Pre-requisites

### Projects that need to be started before
* [config server](/../../blob/master/config-server/README.md) - For pulling the configuration information
* [webservice-registry](/../../blob/master/webservice-registry/README.md) - For starting the Eureka server since the authorization server also is a micro-service that needs to be registered with Eureka server.    

### Running the application
* Build the application by running the `mvn package` gradle command at the "user-webservice" project root folder	on the terminal.
* If you want to run the application as jar file, then run `java -jar build/libs/conversation-service.jar` command at the terminal.

## External Configuration
The project derives it's external configuration from the [config server](/../../blob/master/config-server/README.md) service. Note that we have defined the `spring.cloud.config.uri` in the `bootstrap.yml` file and that tells the application where to pick up the external confiurations. In our case, the URL points to the running [config server](/../../blob/master/config-server/README.md) server. You also need to have the `spring-cloud-config-client` dependency in the classpath so that the application can comsume the config server.

A Spring Cloud application operates by creating a "bootstrap" context, which is a parent context for the main application. This bootstrap context loads properties from external sources (the config-server) and decrypts the properties if required. 

The bootstrap context for external configuration is located by convention at `bootstrap.yml` whereas the internal configuration is located by convention at `application.yml`. Note that you can also have `.properties` file instead of `.yml` files.

## Endpoints
Documentation regarding endpoints can be found in localhost:8081/swagger-ui.html