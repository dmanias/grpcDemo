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
```

### Client

To run the client application, navigate to the grpc-client directory and use the following command:

```bash
mvn spring-boot:run
```

### gRPC Services

The gRPC services are defined in the .proto files located in the src/main/proto directory of the respective modules.

### Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

### License

[MIT](https://choosealicense.com/licenses/mit/)

### Support

If you like this project, don't forget to give it a ⭐️
