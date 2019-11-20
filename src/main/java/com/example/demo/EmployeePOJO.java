package com.example.demo;

public class EmployeePOJO {
    String id;
    String age;
    String name, salary;

    public EmployeePOJO(String id, String age, String name, String salary) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSalary() {
        return salary;
    }
}
