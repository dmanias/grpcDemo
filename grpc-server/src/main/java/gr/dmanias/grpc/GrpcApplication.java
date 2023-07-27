package gr.dmanias.grpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class GrpcApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(GrpcApplication.class, args);

		try {
			GrpcServer grpcServer = context.getBean(GrpcServer.class);
			grpcServer.start();
			grpcServer.blockUntilShutdown();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
