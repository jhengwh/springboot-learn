package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    // Run when a request is received
    @RequestMapping("/test")
    public String test() {
        System.out.println("test() is called!");
        return "Hello World";
    }

    // Run when a request is received
    @RequestMapping("/product")
    public String product() {
        System.out.println("product() is called!");
        return "(1) Apple; (2) Orange.";
    }
}