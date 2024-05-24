package com.szp.demo.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Setter
@Getter
@Entity
@DiscriminatorValue("CAT")

public class Cat extends Pet{
    private Boolean lostTracker;

    @Override
    public void validate() {
        super.validate();
        if (lostTracker == null) {
            throw new IllegalArgumentException("Lost tracker information is required for a cat");
        }
        if (trackerType == TrackerType.MEDIUM) {
            throw new IllegalArgumentException("Cats cannot have medium trackers");
        }
    }
}
