package com.example.multipledatasource.db1.controller;

import com.example.multipledatasource.db1.entity.Employee;
import com.example.multipledatasource.db1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/findAllEmployee")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }
}
