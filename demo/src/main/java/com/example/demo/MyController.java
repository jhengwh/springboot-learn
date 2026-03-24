package com.example.demo;

import org.springframework.web.bind.annotation.*;
/* Includes ...
 * import org.springframework.web.bind.annotation.RequestBody;
 * import org.springframework.web.bind.annotation.RequestMapping;
 * import org.springframework.web.bind.annotation.RequestParam;
 * import org.springframework.web.bind.annotation.RestController;
 * ..., etc.
 */

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

    @RequestMapping("/testReqParam")
    public String testReqParam(@RequestParam Integer id) {
        // Note: class `Integer` is a wrapper class which wraps the primitive `int`
        // value in a object and provides useful methods.

        System.out.println("id: " + id);
        return "Request Succeed.";
    }

    @RequestMapping("/testReqBody")
    public String testReqBody(@RequestBody Student student) {

        System.out.println("student id  : " + student.getId());
        System.out.println("student name: " + student.getName());
        return "Request Succeed (2).";
    }

    @RequestMapping("/testReqHeader")
    public String testReqBody(@RequestHeader(name = "Content-Type") String contentType) {

        System.out.println("Content Type: " + contentType);
        return "Request Succeed (3).";
    }

    @RequestMapping("/testPathVar/{id}")
    public String testPathVar(@PathVariable Integer id) {

        System.out.println("id: " + id);
        return "Request Succeed (4).";
    }
}