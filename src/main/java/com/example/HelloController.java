package com.example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final App app = new App();

    @GetMapping("/")
    public String index() {
        return app.greet("World");
    }

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return app.greet(name);
    }
}
