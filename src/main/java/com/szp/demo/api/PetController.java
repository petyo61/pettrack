package com.szp.demo.api;

import com.szp.demo.model.dto.Count;
import com.szp.demo.model.dto.PetDTO;
import com.szp.demo.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO pet) {
        pet.validate();
        PetDTO savedPet = petService.createAndSavePet(pet);
        return ResponseEntity.ok(savedPet);
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAllPets() {
        List<PetDTO> pets = petService.getAllPets();
        return ResponseEntity.ok(pets);
    }

    @GetMapping("/count")
    public ResponseEntity<Count> countPets(@RequestParam(required = false) String inZone){
        return ResponseEntity.ok(new Count(petService.countPets(inZone)));
    }
}
