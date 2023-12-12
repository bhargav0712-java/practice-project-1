package com.practice.facebook.Controller;

import com.practice.facebook.DTO.BikeDTO;
import com.practice.facebook.Entity.Bike;
import com.practice.facebook.Service.BikeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BIkeController {
    private final BikeService bikeService;

    public BIkeController(BikeService bikeService) {
        this.bikeService = bikeService;
    }
    @PostMapping("/create")
    public ResponseEntity<BikeDTO> createNew(@RequestBody BikeDTO bikeDTO) {
        BikeDTO createdBike = bikeService.createNew(bikeDTO);
        return new ResponseEntity<>(createdBike, HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<BikeDTO> getAllList(){
        return bikeService.getAllList();
    }
    @GetMapping("/find/{id}")
    public BikeDTO findById(@PathVariable Long id){
        return bikeService.getById(id);
    }
    @PutMapping("/update/{id}")
    public BikeDTO updateBike(@PathVariable Long id, @RequestBody BikeDTO bikeDTO){
        return bikeService.updateBike(id, bikeDTO);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(Long id){
        bikeService.deleteById(id);
    }





}
