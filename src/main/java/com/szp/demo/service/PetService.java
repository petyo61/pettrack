package com.szp.demo.service;


import com.szp.demo.model.*;
import com.szp.demo.model.dto.PetDTO;
import com.szp.demo.model.mapper.PetMapper;
import com.szp.demo.persistence.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {

    private final PetMapper petMapper;
    private PetRepository petRepository;

    public PetService(PetRepository petRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.petMapper = petMapper;
    }

    public PetDTO createAndSavePet(PetDTO dto) {
    Pet pet = petMapper.mapToPet(dto);
    pet.validate();
    return petMapper.mapToPetDTO(petRepository.save(pet));
}

    public List<PetDTO> getAllPets() {
        return petRepository.findAll().stream().map(pet -> petMapper.mapToPetDTO(pet)).collect(Collectors.toList());
    }

    public Long countPets(String inZone) {
        if (inZone == null) {
            return petRepository.count();
        }
        return petRepository.countByInZone(Boolean.valueOf(inZone));
    }
}
