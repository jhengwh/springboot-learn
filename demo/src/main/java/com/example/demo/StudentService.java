package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    // Service layer functions are not allowed to directly communicate with the DB
    public String updateStud(Student student) {

        return studentDao.updateStud(student);
    }

    public Student getById(Integer studentId) {

        return studentDao.getById(studentId);
    }
}
