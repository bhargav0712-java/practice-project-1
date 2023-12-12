package com.practice.facebook.Service;

import com.practice.facebook.DTO.BikeDTO;

import java.util.List;

public interface BikeService {
    List<BikeDTO> getAllList();
    BikeDTO createNew(BikeDTO bikeDTO);
    BikeDTO updateBike( Long id , BikeDTO bikeDTO);
    BikeDTO getById(Long id);

    void deleteById(Long id);

}
