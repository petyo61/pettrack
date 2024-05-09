package com.szp.demo.service;


import com.szp.demo.model.ApiPet;
import com.szp.demo.persistence.model.Pet;
import com.szp.demo.persistence.model.PetCategoryCount;
import com.szp.demo.persistence.model.PetFactory;
import com.szp.demo.persistence.model.PetType;
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

    public PetCategoryCount countPets(Boolean inZone) {
        int all = petRepository.countByInZone(inZone);
        int cat = petRepository.countByInZoneAndPetType(inZone, PetType.CAT);
        int dog = petRepository.countByInZoneAndPetType(inZone, PetType.DOG);
        return PetCategoryCount.builder().all(all).cat(cat).dog(dog).build();
    }
}
