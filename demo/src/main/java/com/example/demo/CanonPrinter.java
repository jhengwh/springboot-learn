package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CanonPrinter implements Printer {

    @Value("${count}")
    private int count;

    @Override
    public void print(String message) {
        count--;
        System.out.println("Canon印表機: " + message);
        System.out.println("剩餘使用次數: " + count);
    }
}
