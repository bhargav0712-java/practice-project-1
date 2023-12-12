package com.practice.facebook.Service;

import com.practice.facebook.DTO.HockeyDto;
import com.practice.facebook.Entity.Hockey;
import com.practice.facebook.Repo.HockeyRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HockeyServiceImpl implements HockeyService{
    private final HockeyRepo hockeyRepo;

    public HockeyServiceImpl(HockeyRepo hockeyRepo) {
        this.hockeyRepo = hockeyRepo;
    }

    private HockeyDto convertToDto(Hockey hockey){
        HockeyDto hockeyDto = new HockeyDto();
        hockeyDto.setId(hockey.getId());
        hockeyDto.setCountryName(hockey.getCountry());
        hockeyDto.setWonTheCup(hockey.getWonTheCup());
        hockeyDto.setYear(hockey.getYear());
        return hockeyDto;
    }
    private Hockey convertToEntity(HockeyDto hockeyDto){
        Hockey hockey = new Hockey();
        hockey.setId(hockeyDto.getId());
        hockey.setCountry(hockeyDto.getCountryName());
        hockey.setWonTheCup(hockeyDto.getWonTheCup());
        hockey.setYear(hockeyDto.getYear());
        return  hockey;
    }

    public List<HockeyDto> getAllList(){
        List<HockeyDto> hockeyDtos = new ArrayList<>();
        List<Hockey> hockeys = hockeyRepo.findAll();
        for(Hockey hockey : hockeys){
            hockeyDtos.add(convertToDto(hockey));
        }
        return hockeyDtos;
    }

    public HockeyDto getById(Long id){
        Optional<Hockey> optionalHockey = hockeyRepo.findById(id);
        if(optionalHockey.isPresent()){
            return convertToDto(optionalHockey.get());
        }
        return null;
    }

    public HockeyDto createNew(HockeyDto hockeyDto){
        Hockey hockey = convertToEntity(hockeyDto);
        Hockey hockey1 = hockeyRepo.save(hockey);
        return convertToDto(hockey1);
    }

    public HockeyDto updateOld(Long id, HockeyDto hockeyDto){
        if(hockeyRepo.existsById(id)){
            Hockey hockey = convertToEntity(hockeyDto);
            hockey.setId(id);
            Hockey hockey1 = hockeyRepo.save(hockey);
            return convertToDto(hockey1);
        }
        return null;
    }
    public void deleteById(Long id){
        hockeyRepo.deleteById(id);
    }

}
