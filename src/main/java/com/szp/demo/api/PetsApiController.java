package com.szp.demo.api;

import com.szp.demo.model.ApiPet;
import com.szp.demo.model.PetCount;
import com.szp.demo.persistence.model.PetCategoryCount;
import com.szp.demo.persistence.model.PetType;
import com.szp.demo.service.PetsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PetsApiController implements PetsApi {
    private final PetsService petsService;

    public PetsApiController(PetsService petsService) {
        this.petsService = petsService;
    }

    @Override
    public ResponseEntity<PetCount> countPets(Boolean inZone) {
        if (inZone == null) {
            inZone = false;
        }
        PetCategoryCount count = petsService.countPets(inZone);
        return ResponseEntity.ok(new PetCount().count(count.getAll()).cats(count.getCat()).dogs(count.getDog()));
    }

    @Override
    public ResponseEntity<Void> createPet(ApiPet pet) {
        validatePet(pet);
        petsService.createPet(pet);
        return ResponseEntity.ok().build();
    }

    private void validatePet(ApiPet pet) {
        if (pet.getOwnerId() == null) {
            throw new IllegalArgumentException("Owner id is required");
        }
        if (pet.getPetType() == null) {
            throw new IllegalArgumentException("Pet type is required");
        }
        if (pet.getTrackerType() == null) {
            throw new IllegalArgumentException("Tracker type is required");
        }
        if(pet.getPetType().equals(ApiPet.PetTypeEnum.CAT) && pet.getTrackerType().equals(ApiPet.TrackerTypeEnum.MEDIUM)){
            throw new IllegalArgumentException("Cat cannot have medium tracker");
        }
        if (pet.getPetType().equals(ApiPet.PetTypeEnum.DOG) && pet.getLostTracker() != null){
            throw new IllegalArgumentException("Dog cannot lose tracker");
        }
    }

    @Override
    public ResponseEntity<List<ApiPet>> listPets() {
        List<ApiPet> list = petsService.listPets().stream().map(pet -> new ApiPet()
                .petType(ApiPet.PetTypeEnum.valueOf(pet.getPetType().name()))
                .trackerType(ApiPet.TrackerTypeEnum.valueOf(pet.getTrackerType().name()))
                .lostTracker(pet.isLostTracker())
                .ownerId(pet.getOwnerId())
                .inZone(pet.isInZone())
                .lostTracker(pet.getPetType().equals(PetType.CAT)? pet.isLostTracker() : null))
                .collect(Collectors.toList());
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }


}
