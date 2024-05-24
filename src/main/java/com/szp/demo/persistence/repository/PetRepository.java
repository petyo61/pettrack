package com.szp.demo.persistence.repository;

import com.szp.demo.model.Pet;
import com.szp.demo.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
    Long countByInZone(boolean inZone);
}
