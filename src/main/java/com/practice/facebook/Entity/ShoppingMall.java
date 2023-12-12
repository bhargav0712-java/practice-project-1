package com.practice.facebook.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tb30_shopping_mall")
@Data
public class ShoppingMall {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long shopNo;
    private String shopName;
    private Integer floorNo;
    private Double rent;
    private String category;
}
