package com.example.multipledatasource.db2.controller;

import com.example.multipledatasource.db2.entity.Manager;
import com.example.multipledatasource.db2.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/findAllManager")
    public List<Manager> findAll(){
        return managerService.findAll();
    }
}
