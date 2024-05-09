package com.szp.demo.persistence.model;

import com.szp.demo.model.ApiPet;

public class PetFactory {
    public static Pet of(ApiPet pet) {
        if (pet == null) {
            throw new IllegalArgumentException("Pet cannot be null");
        }
        PetType type = PetType.of(pet.getPetType().name());
        if (type == null) {
            throw new IllegalArgumentException("Pet type has to be either DOG or CAT");
        }
        return Pet.builder()
                .petType(type)
                .ownerId(pet.getOwnerId())
                .trackerType(Trackertype.of(pet.getTrackerType().name()))
                .inZone(true)
                .lostTracker(pet.getLostTracker() != null ? pet.getLostTracker() : false)
                .build();
    }
}
