package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

@Entity
@Table(name = "tb027_motorcycle")
@Data
public class Bike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private String bikeName;
    private Double price;

    @Column(name ="release_year_month")
    private YearMonth releaseDate;
    private Long mileage;

}
