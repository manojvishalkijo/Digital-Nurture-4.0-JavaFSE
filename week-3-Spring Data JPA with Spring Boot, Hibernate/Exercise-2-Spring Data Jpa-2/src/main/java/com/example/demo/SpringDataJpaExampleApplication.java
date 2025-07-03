package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaExampleApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaExampleApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Employee emp = new Employee();
        emp.setName("Amit");
        employeeService.addEmployee(emp);

        System.out.println("Employee saved successfully!");
    }
}
