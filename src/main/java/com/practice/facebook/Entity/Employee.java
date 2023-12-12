package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb028_employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String  designation;
    private Double salary;
    private Integer experience;

}
