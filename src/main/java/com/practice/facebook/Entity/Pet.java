package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb025_pet")
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "breed")
    private String breed;
    @Column(name = "price")
    private Double price;

}
