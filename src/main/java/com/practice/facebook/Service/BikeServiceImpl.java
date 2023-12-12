package com.practice.facebook.Service;

import com.practice.facebook.DTO.BikeDTO;
import com.practice.facebook.DTO.HockeyDto;
import com.practice.facebook.Entity.Bike;
import com.practice.facebook.Repo.BikeRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService {

    private final BikeRepo bikeRepo;

    public BikeServiceImpl(BikeRepo bikeRepo) {
        this.bikeRepo = bikeRepo;
    }

    private BikeDTO convertToDto(Bike bike){
        BikeDTO bikeDTO = new BikeDTO();
        /*bikeDTO.setId(bike.getId());
        bikeDTO.setBikeName(bike.getBikeName());
        bikeDTO.setPrice(bike.getPrice());
        bikeDTO.setReleaseDate(bike.getReleaseDate());
        bikeDTO.setMileage(bike.getMileage()); */
        BeanUtils.copyProperties(bike, bikeDTO);
        return bikeDTO;
    }
    private Bike convertToEntity(BikeDTO bikeDTO){
        Bike bike = new Bike();
        bike.setId(bikeDTO.getId());
        bike.setBikeName(bikeDTO.getBikeName());
        bike.setPrice(bikeDTO.getPrice());
        bike.setReleaseDate(bikeDTO.getReleaseDate());
        bike.setMileage(bikeDTO.getMileage());
        return bike;
    }

    public List<BikeDTO> getAllList(){
        List<BikeDTO> bikeDTOS = new ArrayList<>();
        List<Bike> bikes = bikeRepo.findAll();
        for(Bike bike : bikes){
            bikeDTOS.add(convertToDto(bike));
        }
        return bikeDTOS;
    }
    public BikeDTO createNew(BikeDTO bikeDTO){
        Bike bike = convertToEntity(bikeDTO);
        Bike bike1 = bikeRepo.save(bike);
        return convertToDto(bike1);
    }

    public BikeDTO updateBike(Long id, BikeDTO bikeDTO){
        if(bikeRepo.existsById(id)){
            Bike bike = convertToEntity(bikeDTO);
            bike.setId(id);
            Bike bike1 = bikeRepo.save(bike);
            return convertToDto(bike1);
        }
         return null;
    }

    public BikeDTO getById(Long id ){
        Optional <Bike> optionalBike = bikeRepo.findById(id);
        if(optionalBike.isPresent()){
            return convertToDto(optionalBike.get());
        }
        return null ;
    }
    public void deleteById(Long id){
        bikeRepo.deleteById(id);
    }



}
