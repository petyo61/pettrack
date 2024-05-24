package com.szp.demo.model.dto;

import com.szp.demo.model.PetType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {
    private Long id;
    private String petType;
    private Long ownerId;
    private String trackerType;
    private Boolean inZone;
    private Boolean lostTracker;

    public PetDTO(String petType, Long ownerId, String trackerType, Boolean inZone, Boolean lostTracker) {
        this.petType = petType;
        this.ownerId = ownerId;
        this.trackerType = trackerType;
        this.inZone = inZone;
        this.lostTracker = lostTracker;
    }

    public void validate() {
        if (petType == null || !("DOG".equalsIgnoreCase(petType) || "CAT".equalsIgnoreCase(petType))){
            throw new IllegalArgumentException("Pet type must be DOG or CAT");
        }
        if (ownerId == null) {
            throw new IllegalArgumentException("Owner ID is required");
        }
        if (trackerType == null) {
            throw new IllegalArgumentException("Tracker type is required");
        }
        if (inZone == null) {
            throw new IllegalArgumentException("In zone is required");
        }
        if (lostTracker == null && petType.equalsIgnoreCase("CAT")) {
            throw new IllegalArgumentException("Lost tracker information is required for a cat");
        }
        if (lostTracker != null && petType.equalsIgnoreCase("DOG")){
            throw new IllegalArgumentException("Lost tracker information is not allowed for a dog");
        }

    }
}
