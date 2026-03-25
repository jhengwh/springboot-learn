package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {

    public Map<Integer, String> studData = new HashMap<Integer, String>();

    // To restrict the requested HTTP method to POST only,
    // (1) Uses `@RequestMapping` (longer form)
    //     @RequestMapping(value = "/students", method = RequestMethod.POST)
    // (2) Uses `@PostMapping` (shorter and preferred)
    @PostMapping("/students")
    public String createStud(@RequestBody Student stud) {
        studData.put(stud.getId(), stud.getName());

        System.out.println("student id  : " + stud.getId());
        System.out.println("student name: " + stud.getName());

        return "Create operation.";
    }

    @GetMapping("/students/{studId}")
    public String readStud(@PathVariable Integer studId) {

        System.out.println("student id  : " + studId);
        System.out.println("student name: " + studData.getOrDefault(studId, "N/A"));

        return "Read operation.";
    }

    @PutMapping("/students/{studId}")
    public String updateStud(@PathVariable Integer studId,
                             @RequestBody Student stud) {

        studData.putIfAbsent(studId, stud.getName());

        System.out.println("student id  : " + studId);
        System.out.println("student name: " + studData.getOrDefault(studId, "N/A"));

        return "Update operation.";
    }

    @DeleteMapping("/students/{studId}")
    public String deleteStud(@PathVariable Integer studId) {

        studData.remove(studId);

        System.out.println("student id  : " + studId);
        System.out.println("student name: " + studData.getOrDefault(studId, "N/A"));

        return "Delete operation.";
    }
}
