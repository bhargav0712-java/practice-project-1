package com.practice.facebook.DTO;

import lombok.*;

import java.time.Year;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HockeyDto {
    private Long id;
    private String countryName;
    private Long wonTheCup;
    private Year year;
}
