package com.example.demo;

import org.jspecify.annotations.Nullable;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

// Note: remember to give typename (e.g. class `Student`) to RowMapper
public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student stud = new Student();
        stud.setId(rs.getInt("id"));
        stud.setName(rs.getString("name"));
        return stud;
    }
}
