package com.practice.facebook.Controller;

import com.practice.facebook.Entity.ShoppingMall;
import com.practice.facebook.Service.ShoppingMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/mall")
public class ShoppingMallController {
    private final ShoppingMallService shoppingMallService;
    @Autowired
    public ShoppingMallController(ShoppingMallService shoppingMallService) {
        this.shoppingMallService = shoppingMallService;
    }
    @GetMapping("/shoplist")
    public ResponseEntity<List<ShoppingMall>> listAllShops(){
        List<ShoppingMall> malls = shoppingMallService.allShopsList();
        return new ResponseEntity<>(malls, HttpStatus.OK);
    }
    @PostMapping("/create/shop")
    public ResponseEntity<ShoppingMall> createNewShop(@RequestBody ShoppingMall shoppingMall){
        ShoppingMall shoppingMall1 = shoppingMallService.createNewShop(shoppingMall);
        return new ResponseEntity<>(shoppingMall1, HttpStatus.CREATED);
    }
    @GetMapping("/shop/name/{shopName}")
    public ResponseEntity<Optional<ShoppingMall>> findById(@PathVariable Long shopNo){
        Optional<ShoppingMall> shoppingMall = shoppingMallService.findById(shopNo);
        if(shoppingMall.isPresent()){
            return new ResponseEntity<>(shoppingMall, HttpStatus.CREATED);
        } else {return new ResponseEntity<>(HttpStatus.NOT_FOUND); }
    }
    @PutMapping("/shop/update/{shopNo}")
    public ResponseEntity<ShoppingMall> updateShop(@PathVariable Long shopNo, @RequestBody ShoppingMall shoppingMall){
        ShoppingMall shoppingMall1 = shoppingMallService.updateShop(shopNo, shoppingMall);
        return new ResponseEntity<>(shoppingMall1,HttpStatus.ACCEPTED);

    }
    @DeleteMapping("/delete/shopNo/{shopNo}")
    public ResponseEntity<Void> deleteById(@PathVariable Long shopNo){
        shoppingMallService.deleteById(shopNo);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete/shopName/{shopName}")
    public ResponseEntity<Void> deleteByShopNAme(@PathVariable String shopName){
        shoppingMallService.deleteByShopName(shopName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/shop/detail/shopname/{shopName}")
    public ResponseEntity<List<ShoppingMall>> findByShopName(@PathVariable String shopName){
        List<ShoppingMall> malls = shoppingMallService.findByShopName(shopName);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/shop/detail/category/{category}")
    public ResponseEntity<List<ShoppingMall>> findByCategory(@PathVariable String category){
        List<ShoppingMall> malls = shoppingMallService.findByCategory(category);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/shop/detail/floorNo/{floorNo}")
    public ResponseEntity<List<ShoppingMall>> findByFloorNo(@PathVariable Integer floorNo){
        List<ShoppingMall> malls = shoppingMallService.findByFloorNo(floorNo);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/shop/details/rent/lessthan/{rent}")
    public ResponseEntity<List<ShoppingMall>> findByRentLessThan(@PathVariable Double rent){
        List<ShoppingMall> malls = shoppingMallService.findByRentLessThan(rent);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/shop/details/rent/greaterthan/{rent}")
    public ResponseEntity<List<ShoppingMall>> findByRentGreaterThan(@PathVariable Double rent){
        List<ShoppingMall> malls = shoppingMallService.findByRentGreaterThan(rent);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/shop/details/category-floorNo/{category}/{floorNo}")
    public ResponseEntity<List<ShoppingMall>> findByCategoryFloorNo(@PathVariable String category, @PathVariable Integer floorNo ){
        List<ShoppingMall> malls = shoppingMallService.findByCategoryAndFloorNo(category, floorNo);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/shop/details/category/lessRent/{category}/{rent}")
    public ResponseEntity<List<ShoppingMall>> findByCategoryAndRentLessThan(@PathVariable String category,@PathVariable Double rent){
        List<ShoppingMall> malls = shoppingMallService.findByCategoryAndRentLessThan(category, rent);
        if (malls != null){
            return new ResponseEntity<>(malls, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/shop/details/category/count/{category}")
    public ResponseEntity<Long> countByCategory(@PathVariable String category){
        Long shoppingMall = shoppingMallService.countByCategory(category);
        return new ResponseEntity<>(shoppingMall, HttpStatus.OK);
    }
}
