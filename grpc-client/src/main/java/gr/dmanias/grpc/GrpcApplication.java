package gr.dmanias.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcApplication.class, args);

		// Create an instance of the gRPC client
		GrpcClient client = new GrpcClient("localhost", 50051);

		try {
			// Use the client to send a greeting
			client.greet("Client");
		} finally {
			// Shutdown the client when you're finished with it
			try {
				client.shutdown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
