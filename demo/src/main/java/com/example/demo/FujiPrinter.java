package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class FujiPrinter implements Printer {

    @Override
    public void print(String message) {
        System.out.println("Fujifilm印表機: " + message);
    }
}
