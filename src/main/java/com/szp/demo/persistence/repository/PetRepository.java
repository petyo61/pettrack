package com.szp.demo.persistence.repository;

import com.szp.demo.persistence.model.Pet;
import com.szp.demo.persistence.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    int countByInZone(boolean inZone);
    int countByInZoneAndPetType(boolean inZone, PetType petType);
}
