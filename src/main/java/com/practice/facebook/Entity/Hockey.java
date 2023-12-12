package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;

@Entity
@Table(name = "tb026_hockey")
@Data
public class Hockey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String country;
    private Long wonTheCup;
    private Year year;

}
