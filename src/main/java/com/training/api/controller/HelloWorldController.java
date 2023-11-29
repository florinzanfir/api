package com.training.api.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // HTTP Get Request
    // http://localhost:8080/hello-world
    @GetMapping("/hello-world")
    public String helloWorld() {

        return "Hello world!";
    }
}
