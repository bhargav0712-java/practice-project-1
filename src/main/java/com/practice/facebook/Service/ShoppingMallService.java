package com.practice.facebook.Service;

import com.practice.facebook.Entity.ShoppingMall;
import com.practice.facebook.Repo.ShoppingMallRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingMallService {
    private final ShoppingMallRepo shoppingMallRepo;
    @Autowired
    public ShoppingMallService(ShoppingMallRepo shoppingMallRepo) {
        this.shoppingMallRepo = shoppingMallRepo;
    }
    public List<ShoppingMall> allShopsList(){
        return shoppingMallRepo.findAll();
    }
    public ShoppingMall createNewShop(ShoppingMall shoppingMall){
        return shoppingMallRepo.save(shoppingMall);
    }
    public Optional<ShoppingMall> findById(Long shopNo){
        return shoppingMallRepo.findById(shopNo);
    }
    public ShoppingMall updateShop(Long shopNo, ShoppingMall shoppingMall){
        if(shoppingMallRepo.existsById(shopNo)){
            return shoppingMallRepo.save(shoppingMall);
        }
        return null;
    }
    public void deleteById(Long shopNo){
        shoppingMallRepo.deleteById(shopNo);
    }
    public List<ShoppingMall> findByShopName(String shopName){
        return shoppingMallRepo.findByShopNameIgnoreCase(shopName);
    }
    public List<ShoppingMall> findByCategory(String category){
        return shoppingMallRepo.findByCategoryIgnoreCase(category);
    }
    public List<ShoppingMall> findByFloorNo(Integer floorNo){
        return shoppingMallRepo.findByFloorNo(floorNo);
    }
    public List<ShoppingMall> findByRentLessThan(Double rent){
        return shoppingMallRepo.findByRentLessThan(rent);
    }
    public List<ShoppingMall> findByRentGreaterThan(Double rent){
        return shoppingMallRepo.findByRentGreaterThan(rent);
    }
    public List<ShoppingMall> findByCategoryAndFloorNo(String category, Integer floorNo){
        return shoppingMallRepo.findByCategoryAndFloorNo(category, floorNo);
    }
    public List<ShoppingMall> findByCategoryAndRentLessThan(String category, Double rent){
        return shoppingMallRepo.findByCategoryAndRentLessThan(category, rent);
    }
    public Long countByCategory(String category){
        return shoppingMallRepo.countByCategoryIgnoreCase(category);
    }
    public void deleteByShopName(String shopName){
        shoppingMallRepo.deleteByShopNameIgnoreCase(shopName);
    }


























}
















