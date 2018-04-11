package br.com.claudiobs07.circuitbreakerexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class CircuitBreakerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitBreakerExampleApplication.class, args);
	}
}

