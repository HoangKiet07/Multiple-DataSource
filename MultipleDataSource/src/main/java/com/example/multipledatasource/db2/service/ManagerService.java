package com.example.multipledatasource.db2.service;

import com.example.multipledatasource.db2.entity.Manager;
import com.example.multipledatasource.db2.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerService {
    @Autowired
    private ManagerRepository managerRepository;

    public List<Manager> findAll() {
        return managerRepository.findAll();

    }
}