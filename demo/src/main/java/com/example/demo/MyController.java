package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    @Qualifier("canonPrinter")
    private Printer printer;

    // Run when a request is received
    @RequestMapping("/test")
    public String test() {
        printer.print("Hi!");
        return "Hello World";
    }
}