package com.practice.facebook.DTO;

import lombok.Data;

import java.time.Year;
import java.time.YearMonth;
import java.util.Date;

@Data
public class BikeDTO {
    private Long id;
    private String bikeName;
    private Double price;
    private YearMonth releaseDate;
    private Long mileage;
}
