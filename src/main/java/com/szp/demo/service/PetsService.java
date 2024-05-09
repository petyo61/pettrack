package com.szp.demo.service;


import com.szp.demo.model.ApiPet;
import com.szp.demo.persistence.model.Pet;
import com.szp.demo.persistence.model.PetFactory;
import com.szp.demo.persistence.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetsService {
    private final PetRepository petRepository;

    public PetsService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public void createPet(ApiPet pet) {
        Pet newPet = PetFactory.of(pet);
        petRepository.save(newPet);
    }

    public List<Pet> listPets() {
        return petRepository.findAll();
    }
}
