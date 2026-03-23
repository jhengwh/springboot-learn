package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
    public Shop product() {
        Shop shop = new Shop();
        List<String> goods = new ArrayList<>();

        goods.add("Apple");
        goods.add("Orange");
        shop.setProductList(goods);

        System.out.println("product() is called!");

        // Let the function return a Java object
        // By annotating the class with `@RestController`, the returned Java object is automatically
        // converted to JSON format before being sent back to the front end.
        return shop;
    }

    @RequestMapping("/test1")
    public String test1(@RequestParam Integer id) {
        // Note: class `Integer` is a wrapper class which wraps the primitive `int`
        // value in a object and provides useful methods.

        System.out.println("id: " + id);
        return "Request Succeed.";
    }
}