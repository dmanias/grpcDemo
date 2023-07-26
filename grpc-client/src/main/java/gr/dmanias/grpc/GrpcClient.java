package gr.dmanias.grpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.concurrent.TimeUnit;

public class GrpcClient {

    private final ManagedChannel channel;
    private final GreetingServiceGrpc.GreetingServiceBlockingStub blockingStub;

    public GrpcClient(String host, int port) {
        this.channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();
        this.blockingStub = GreetingServiceGrpc.newBlockingStub(channel);
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }

    public void greet(String name) {
        // Prepare the request
        Greeting.GreetingRequest request = Greeting.GreetingRequest.newBuilder().setName(name).build();

        // Send the request and get the response
        Greeting.GreetingResponse response = blockingStub.greet(request);

        // Print the response
        System.out.println("Response from server: " + response.getMessage());
    }

}
