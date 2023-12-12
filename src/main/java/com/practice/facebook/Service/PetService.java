package com.practice.facebook.Service;

import com.practice.facebook.Entity.Pet;
import com.practice.facebook.Repo.PetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private final PetRepo petRepo;
    @Autowired
    public PetService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public List<Pet> allPetList(){
        return petRepo.findAll();
    }
    public Pet createNew(Pet pet){
        return petRepo.save(pet);
    }
    public Pet updatePet(Long id,  Pet pet ){
        if(petRepo.existsById(id)){
            return petRepo.save(pet);
        }
        return null;
    }
    public Optional<Pet> listById(Long id){
        return petRepo.findById(id);
    }
    public void deleteId (Long id){
        petRepo.deleteById(id);
    }
}
