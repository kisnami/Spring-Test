package com.example.demo;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpRowMapper implements RowMapper<EmployeePOJO> {
    @Override
    public EmployeePOJO mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new EmployeePOJO(rs.getString("id"), rs.getString("name"), rs.getString("salary"), rs.getString("age"));
    }
}
