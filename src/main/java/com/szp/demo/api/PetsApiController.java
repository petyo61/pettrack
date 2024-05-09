package com.szp.demo.api;

import com.szp.demo.model.ApiPet;
import com.szp.demo.service.PetsService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class PetsApiController implements PetsApi{
    private final PetsService petsService;

    public PetsApiController(PetsService petsService) {
        this.petsService = petsService;
    }

    @Override
    public ResponseEntity<Void> createPet(ApiPet pet) {
        petsService.createPet(pet);
        return ResponseEntity.ok().build();
    }

}
