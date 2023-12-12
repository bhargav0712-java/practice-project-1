package com.practice.facebook.Service;

import com.practice.facebook.DTO.HockeyDto;

import java.util.List;

public interface HockeyService {
    List<HockeyDto> getAllList();
    HockeyDto getById(Long id);
    HockeyDto createNew(HockeyDto hockeyDto);
    HockeyDto updateOld(Long id, HockeyDto hockeyDto);
    void deleteById(Long id);
}
