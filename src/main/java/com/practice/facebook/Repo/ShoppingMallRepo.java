package com.practice.facebook.Repo;

import com.practice.facebook.Entity.ShoppingMall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingMallRepo extends JpaRepository<ShoppingMall, Long> {
    List<ShoppingMall> findByShopNameIgnoreCase(String shopName);
    List<ShoppingMall> findByCategoryIgnoreCase(String category);
    List<ShoppingMall> findByFloorNo(Integer floorNo);
    List<ShoppingMall> findByRentLessThan(Double rent);
    List<ShoppingMall> findByRentGreaterThan(Double rent);
    List<ShoppingMall> findByCategoryAndFloorNo(String category, Integer floorNo);
    List<ShoppingMall> findByCategoryAndRentLessThan(String category, Double rent);
    Long countByCategoryIgnoreCase(String category);
    void deleteByShopNameIgnoreCase(String shopName);



}
