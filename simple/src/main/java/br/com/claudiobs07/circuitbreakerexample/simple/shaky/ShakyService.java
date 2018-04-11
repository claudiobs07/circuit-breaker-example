package br.com.claudiobs07.circuitbreakerexample.simple.shaky;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

@Service
public class ShakyService {

    public int fallback() {
        return 2;
    }

    @HystrixCommand(fallbackMethod = "fallback")
    public int deriveNumber() throws Exception {
        if (Math.random() > 0.5) {
            Thread.sleep(1000 * 3);
            throw new RuntimeException("Boom!");
        }
        return 1;
    }

}
