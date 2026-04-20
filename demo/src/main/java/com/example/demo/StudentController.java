package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @RequestMapping("/students")
    public String insert(@RequestBody Student stud) {

        // A colon ":" used in SQL is to bind a variable
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", stud.getId());
        map.put("studentName", stud.getName());

        namedParameterJdbcTemplate.update(sql, map);

        return "Executes INSERT SQL.";
    }

    @RequestMapping("/getStudents")
    public List<Student> query(@RequestBody Integer queriedId) {
        String sql = "SELECT id,name FROM student WHERE id = :qId";

        Map<String, Object> map = new HashMap<>();
        map.put("qId", queriedId);

        StudentRowMapper rowMapper = new StudentRowMapper();

        List<Student> studList = namedParameterJdbcTemplate.query(sql, map, rowMapper);

        return studList;
    }
}
