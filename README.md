# gRPC with Spring Boot

This project is a demonstration of using gRPC with Spring Boot. The project includes both a server module and a client module.

## Prerequisites

- Java 17
- Maven
- An IDE (e.g., IntelliJ IDEA)

## Project Structure

This project is divided into two modules:

1. **grpc-server** - This module handles all server-side operations, including the implementation of the gRPC service.

2. **grpc-client** - This module handles all client-side operations, and contains a simple Spring Boot application which consumes the gRPC service.

## Running the Project

### Server

To run the server application, navigate to the `grpc-server` directory and use the following command:

```bash
mvn spring-boot:run
