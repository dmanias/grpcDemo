package gr.dmanias.grpc;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greet(Greeting.GreetingRequest request, StreamObserver<Greeting.GreetingResponse> responseObserver) {
        String name = request.getName();

        // Log the request
        System.out.println("Received a request from " + name);

        String message = "Hello, " + name + "!";

        Greeting.GreetingResponse response = Greeting.GreetingResponse.newBuilder().setMessage(message).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
