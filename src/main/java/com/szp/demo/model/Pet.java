package com.szp.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "petType")
public abstract class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "petType", insertable = false, updatable = false)
    private PetType petType;
    private Long ownerId;
    @Enumerated(EnumType.STRING)
    protected TrackerType trackerType;
    protected Boolean inZone;


    public void validate() {
        if (ownerId == null) {
            throw new IllegalArgumentException("Owner ID is required");
        }
        if (trackerType == null) {
            throw new IllegalArgumentException("Tracker type is required");
        }
        if (inZone == null) {
            throw new IllegalArgumentException("In zone is required");
        }
    }
}
