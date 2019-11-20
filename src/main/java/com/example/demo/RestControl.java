package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class RestControl {
    @Autowired
    RestServices services;

    @RequestMapping(value = "/createTable", method = RequestMethod.GET)
    public ResponseEntity tableCreate() {
        return services.createTable();

    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public List<EmployeePOJO> addEmployee() {
        EmployeePOJO employeePOJO = new EmployeePOJO(String.valueOf(new Random().nextInt()), String.valueOf(new Random().nextInt()), String.valueOf(new Random().nextInt()), String.valueOf(new Random().nextInt()));
        List<EmployeePOJO> e = new ArrayList<>();
        e.add(employeePOJO);
        return services.addEmployee(e);
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
    public List<EmployeePOJO> getEmployee() {
        return services.getEmployee();
    }

    @RequestMapping("/exception/{id}")
    public void throwExc(@PathVariable("id") int id) throws Exc {
        System.out.println("ypur id " + id);
        switch (id) {
            case 1:
                throw new Exc("" + id);
            case 2:
                throw new Exc("" + id);
            case 3:
                throw new Exc("" + id);
            case 4:
                throw new Exc("" + id);
            default:
                throw new Exc("poda punda");


        }
    }
}
