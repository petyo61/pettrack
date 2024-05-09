package com.szp.demo.api;

import com.szp.demo.model.ApiPet;
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
    public ResponseEntity<Void> createPet(ApiPet pet) {
        petsService.createPet(pet);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<List<ApiPet>> listPets() {
        List<ApiPet> list = petsService.listPets().stream().map(pet -> new ApiPet()
                .petType(ApiPet.PetTypeEnum.valueOf(pet.getPetType().name()))
                .trackerType(ApiPet.TrackerTypeEnum.valueOf(pet.getTrackerType().name()))
                .lostTracker(pet.isLostTracker())
                .ownerId(pet.getOwnerId())
                .inZone(pet.isInZone())
                .lostTracker(pet.isLostTracker())).collect(Collectors.toList());
        return list.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(list);
    }


}
