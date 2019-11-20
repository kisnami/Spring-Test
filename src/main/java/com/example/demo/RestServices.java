package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class RestServices {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public ResponseEntity createTable() {
        try {
            jdbcTemplate.execute("create table if not exits employee(id int,name varchar(99),salary varchar(99),age int);");
            return new ResponseEntity(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    public List<EmployeePOJO> addEmployee(List<EmployeePOJO> employeePOJO) {
        try {
            jdbcTemplate.execute("create table if not exists employee(id varchar(99),name varchar(99),salary varchar(99),age varchar(99));");
            String query = "insert into employee values('" + employeePOJO.get(0).getId() + "','" + employeePOJO.get(0).getName() + "'" + ",'" + employeePOJO.get(0).getSalary() + "'" + ",'" + employeePOJO.get(0).getAge() + "');";
            System.out.println(query);
            jdbcTemplate.update(query);
            return employeePOJO;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<EmployeePOJO> getEmployee() {
        return jdbcTemplate.query("select * from employee;", new EmpRowMapper());

    }
}
