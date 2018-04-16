package br.com.claudiobs07.simple.shaky;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ShakyService {

    private static final Logger logger = LoggerFactory.getLogger(ShakyService.class);

    public int fallback() {
        return 2;
    }

    @HystrixCommand(commandKey = "deriveNumber", fallbackMethod = "fallback", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000")
    })
    public int deriveNumber() throws Exception {
        Thread.sleep(1000 * 3);
        if (Math.random() > 0.5) {
            throw new RuntimeException("Boom!");
        }
        return 1;
    }

}
