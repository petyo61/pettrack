package com.szp.demo.persistence.repository;

import com.szp.demo.persistence.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
