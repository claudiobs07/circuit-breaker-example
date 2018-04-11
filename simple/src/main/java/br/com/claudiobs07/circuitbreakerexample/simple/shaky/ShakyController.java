package br.com.claudiobs07.circuitbreakerexample.simple.shaky;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShakyController {

    private final ShakyService shakyService;

    public ShakyController(ShakyService shakyService) {
        this.shakyService = shakyService;
    }

    @GetMapping("/boom")
    public int boom() throws Exception {
        return shakyService.deriveNumber();
    }

}
