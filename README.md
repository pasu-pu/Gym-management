# Google RPC Template

This repository contains a template for a Google RPC project in Java. 

## Introduction

* The `proto` file to configure messages and services is located in `src/main/proto/`. 
* To execute the demo, the `protoc` compiler and the `grpc` generator have to create some classes in 
`src/main/java/de/thws/fiw/backendsystems/templates/grpc`. 
* This happens during the build process: `mvn clean package`. 
* It should not be necessary to have the `protoc` compiler previously installed on your system (using `brew` or so).
 
## Run the small demo in the IDE

* Call `mvn clean package` to create missing Java classes.
* Execute the `main` method in class `src/main/java/de/thws/fiw/backendsystems/templates/grpc/GreeterServer.java` to start the server.
* Execute the `main` method in class `src/main/java/de/thws/fiw/backendsystems/templates/grpc/Client.java` to start the client.

## Run integration tests using Docker

* Call `mvn -f pom-docker.xml verify`
* Current, no integration tests are implemented
