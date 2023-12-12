package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb029_student_result")
@Data
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long rollNo;
    private String studentName;
    private String email;
    private String branch;
    private String result;

}
