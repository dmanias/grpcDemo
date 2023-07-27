package gr.dmanias.grpc;

import io.grpc.stub.StreamObserver;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest;
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Autowired
    private GrpcLogRepository logRepository;

//    @Autowired
//    private RestHighLevelClient client;
//    public void testConnection() {
//        try {
//            ClusterHealthRequest request = new ClusterHealthRequest();
//            ClusterHealthResponse response = client.cluster().health(request, RequestOptions.DEFAULT);
//            System.out.println("Cluster health status: " + response.getStatus());
//        } catch (Exception e) {
//            System.err.println("Exception occurred during connection test: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }


    @Override
    public void greet(Greeting.GreetingRequest request, StreamObserver<Greeting.GreetingResponse> responseObserver) {
        try {
//            testConnection();
            String name = request.getName();

            // Log the request
            System.out.println("Received a request from " + name);

            String message = "Hello, " + name + "!";

            Greeting.GreetingResponse response = Greeting.GreetingResponse.newBuilder().setMessage(message).build();

            // Save the request and response to Elasticsearch
            GrpcLog log = new GrpcLog();
            log.setRequest(name);
            log.setResponse(message);
            log.setTimestamp(new Date());

            logRepository.save(log);  // This is where the error might occur.

            responseObserver.onNext(response);
            responseObserver.onCompleted();
        } catch (Exception e) {
            System.err.println("Exception occurred during processing: " + e.getMessage());
            e.printStackTrace();

            // Ensure the RPC call completes even when there's an error.
            responseObserver.onError(e);
        }
    }
}

