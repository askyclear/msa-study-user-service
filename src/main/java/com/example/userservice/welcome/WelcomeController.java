package com.example.userservice.welcome;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class WelcomeController {
    @GetMapping("/welcome")
    public String welcome() {
        return "user - welcome";
    }

    @GetMapping("/message")
    public String message(@RequestHeader("user-request") String header) {
        log.info(header);
        return "Hello World in User Service.";
    }
    @GetMapping("/check")
    public String check() {
        return "Hi, there. this is a message from User Service";
    }
}
