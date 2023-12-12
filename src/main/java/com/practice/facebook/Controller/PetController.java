package com.practice.facebook.Controller;

import com.practice.facebook.Entity.Pet;
import com.practice.facebook.Service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pet")
public class PetController {
    private final PetService petService;
    @Autowired
    public PetController(PetService petService) {
        this.petService = petService;
    }
    @GetMapping("/list")
    public List<Pet> getAllPets(){
        return petService.allPetList();
    }
    @GetMapping("/list/{id}")
    public Optional<Pet> listById(@PathVariable Long id){
        return petService.listById(id);
    }
    @PostMapping("/create")
    public Pet createNew( @RequestBody Pet pet){
        return petService.createNew(pet);
    }
    @PutMapping("/update/{id}")
    public Pet UpdatePet(@PathVariable Long id, @RequestBody Pet pet){
        return petService.updatePet(id, pet);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        petService.deleteId(id);
    }

}
