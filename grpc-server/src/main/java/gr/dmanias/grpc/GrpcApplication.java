package gr.dmanias.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrpcApplication.class, args);

		try {
			GrpcServer grpcServer = new GrpcServer();
			grpcServer.start();
			grpcServer.blockUntilShutdown();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
