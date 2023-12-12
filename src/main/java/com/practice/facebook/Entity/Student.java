package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Table(name = "tb031_student_data")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rollNo;
    private String studentName;
    private String email;
    private Integer result;
    private Date dateOfBirth;
    private String gender;

}
