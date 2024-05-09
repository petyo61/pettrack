package com.szp.demo;

import com.szp.demo.persistence.model.Pet;
import com.szp.demo.persistence.model.PetType;
import com.szp.demo.persistence.model.Trackertype;
import com.szp.demo.persistence.repository.PetRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PetRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Test
    public void saveAndFindPet() {
        // given
        Pet savedPet = Pet.builder()
                .petType(PetType.CAT)
                .trackerType(Trackertype.SMALL)
                .ownerId(7L)
                .lostTracker(true)
                .inZone(true)
                .build();
        entityManager.persist(savedPet);
        entityManager.flush();

        // when
        Pet foundPet = petRepository.findById(savedPet.getId()).orElse(null);

        // then
        assertThat(foundPet).isNotNull();
        assertThat(foundPet.getPetType()).isEqualTo(PetType.CAT);
    }
}