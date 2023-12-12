package com.practice.facebook.Controller;

import com.practice.facebook.DTO.HockeyDto;
import com.practice.facebook.Service.HockeyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hockey")
public class HockeyController {
    private final HockeyService hockeyService;

    public HockeyController(HockeyService hockeyService) {
        this.hockeyService = hockeyService;
    }
    @GetMapping("/list")
    public List<HockeyDto> getAllList(){
        return hockeyService.getAllList();
    }
    @GetMapping("/list/{id}")
    public HockeyDto getById(@PathVariable Long id){
        return hockeyService.getById(id);
    }
    @PostMapping("/create")
    public HockeyDto createNew(@RequestBody HockeyDto hockeyDto){
        return hockeyService.createNew(hockeyDto);
    }
    @PutMapping("/update/{id}")
    public HockeyDto updateNew(@PathVariable Long id, @RequestBody HockeyDto hockeyDto){
        return hockeyService.updateOld(id, hockeyDto);
    }
    @DeleteMapping("/delete/{id}")
        public void deleteRecord(@PathVariable Long id){
            hockeyService.deleteById(id);

    }
}
