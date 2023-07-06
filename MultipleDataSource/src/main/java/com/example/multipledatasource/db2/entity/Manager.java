package com.example.multipledatasource.db2.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "salary")
    private String salary;
}
