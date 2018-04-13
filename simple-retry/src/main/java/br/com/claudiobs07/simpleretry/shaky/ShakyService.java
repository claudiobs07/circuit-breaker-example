package br.com.claudiobs07.simpleretry.shaky;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class ShakyService {

    private static final Logger logger = LoggerFactory.getLogger(ShakyService.class);

    @Recover
    public int fallback(RuntimeException ex) {
        return 2;
    }

    @Retryable(include = BoomException.class)
    public int deriveNumber() throws Exception {
        logger.info("calling derive number");
        if (Math.random() > 0.5) {
            Thread.sleep(1000 * 3);
            throw new RuntimeException("Boom!");
        }
        return 1;
    }

}
