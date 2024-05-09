package com.szp.demo.persistence.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private PetType petType;
    private Long ownerId;
    private Trackertype trackerType;
    private boolean inZone;
    private boolean lostTracker;

    public static Pet dog(Long ownerId, Trackertype trackerType, boolean inZone, boolean lostTracker) {
        return Pet.builder()
                .petType(PetType.DOG)
                .ownerId(ownerId)
                .trackerType(trackerType)
                .inZone(inZone)
                .build();

    }

    public static Pet cat(Long ownerId, Trackertype trackerType, boolean inZone, boolean lostTracker) {
        return Pet.builder()
                .petType(PetType.CAT)
                .ownerId(ownerId)
                .trackerType(trackerType)
                .inZone(inZone)
                .lostTracker(lostTracker)
                .build();
    }
}
