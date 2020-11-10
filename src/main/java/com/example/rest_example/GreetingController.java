package com.example.rest_example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

// create controller

@RestController
public class GreetingController {
    // %s is a placeholder
    // s indicates that it is a placeholder for a string
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name){
        // return new greeting object
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
