package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Component
public class StudentDao {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public String updateStud(Student student) {

        // A colon ":" used in SQL is to bind a variable
        String sql = "INSERT INTO student(id, name) VALUES (:studentId, :studentName)";

        Map<String, Object> map = new HashMap<>();
        map.put("studentId", student.getId());
        map.put("studentName", student.getName());

        namedParameterJdbcTemplate.update(sql, map);

        return "Executes INSERT SQL.";
    }

    public Student getById(Integer studentId) {

        String sql = "SELECT id,name FROM student WHERE id = :qId";

        Map<String, Object> map = new HashMap<>();
        map.put("qId", studentId);

        List<Student> studentList = namedParameterJdbcTemplate.query(
                sql, map, new StudentRowMapper()
        );

        if (studentList.size() > 0) {
            return studentList.get(0);
        } else {
            return null;
        }
    }
}
