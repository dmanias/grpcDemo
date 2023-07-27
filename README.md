# gRPC with Spring Boot

This project is a demonstration of using gRPC with Spring Boot. The project includes both a server module and a client module.

## Prerequisites

- Java 17
- Maven
- Elasticsearch 7.14 or higher
- An IDE (e.g., IntelliJ IDEA)

## Project Structure

This project is divided into two modules:

1. **grpc-server** - This module handles all server-side operations, including the implementation of the gRPC service and Elasticsearch logging.

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

### Elasticsearch Logging

When the gRPC server receives a request, it logs the request and response to Elasticsearch. You can check that this is working by sending a gRPC request from your client, and then checking Elasticsearch to see if the log document was created.

You can check the logs in Elasticsearch using the following curl command:

```bash
curl -X GET "localhost:9200/grpclogs/_search?pretty" -H 'Content-Type: application/json' -d'
{
    "query": {
        "match_all": {}
    }
}
'
```
This should return all documents in the "grpclogs" index, which should include the log for the gRPC request you sent.

### Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

### License

[MIT](https://choosealicense.com/licenses/mit/)

### Support

If you like this project, don't forget to give it a ⭐️
