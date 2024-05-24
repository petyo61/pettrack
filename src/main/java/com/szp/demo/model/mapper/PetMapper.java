package com.szp.demo.model.mapper;

import com.szp.demo.model.Cat;
import com.szp.demo.model.Dog;
import com.szp.demo.model.Pet;
import com.szp.demo.model.TrackerType;
import com.szp.demo.model.dto.PetDTO;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {
    public Pet mapToPet(PetDTO petDTO) {
        Pet pet;
        switch (petDTO.getPetType().toUpperCase()) {
            case "DOG":
                pet = new Dog();
                break;
            case "CAT":
                pet = new Cat();
                break;
            default:
                throw new IllegalArgumentException("Unsupported pet type: " + petDTO.getPetType());
        }
        pet.setOwnerId(petDTO.getOwnerId());
        pet.setTrackerType(TrackerType.of(petDTO.getTrackerType()));
        pet.setInZone(petDTO.getInZone());
        if (pet instanceof Cat) {
            ((Cat) pet).setLostTracker(petDTO.getLostTracker());
        }
        return pet;
    }

    public PetDTO mapToPetDTO(Pet pet) {
        PetDTO dto = new PetDTO();
        dto.setId(pet.getId());
        dto.setPetType(pet.getClass().getSimpleName().toUpperCase());
        dto.setOwnerId(pet.getOwnerId());
        dto.setTrackerType(pet.getTrackerType().name());
        dto.setInZone(pet.getInZone());
        if (pet instanceof Cat) {
            dto.setLostTracker(((Cat) pet).getLostTracker());
        }
        return dto;
    }

}
