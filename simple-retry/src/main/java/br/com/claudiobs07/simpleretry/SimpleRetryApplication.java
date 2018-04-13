package br.com.claudiobs07.simpleretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class SimpleRetryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleRetryApplication.class, args);
    }
}
