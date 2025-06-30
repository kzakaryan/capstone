package am.capstone.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EurekaTestController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/whoami")
    public String whoAmI() {
        return "Hello from port " + port;
    }
}
