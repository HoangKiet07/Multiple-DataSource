package com.example.multipledatasource.db1.service;

import com.example.multipledatasource.db1.entity.Employee;
import com.example.multipledatasource.db1.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
}
