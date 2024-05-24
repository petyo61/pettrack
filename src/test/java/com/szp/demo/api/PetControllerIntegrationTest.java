package com.szp.demo.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.szp.demo.model.dto.PetDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PetControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createPet_ShouldReturnCreatedPet() throws Exception {
        PetDTO petDTO = new PetDTO("DOG", 1L, "Medium", true, false);
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(petDTO)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNotEmpty());
    }

    @Test
    public void createPet_ShouldReturnBadRequest() throws Exception {
        PetDTO petDTO = new PetDTO();
        petDTO.setPetType("DOG");
        petDTO.setOwnerId(1L);
        petDTO.setTrackerType("Medium");
        petDTO.setInZone(true);
        petDTO.setLostTracker(true);
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(petDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void createPet_ShouldReturnBadRequestForInvalidPetType() throws Exception {
        PetDTO petDTO = new PetDTO();
        petDTO.setPetType("RABBIT");
        petDTO.setOwnerId(1L);
        petDTO.setTrackerType("Medium");
        petDTO.setInZone(true);
        petDTO.setLostTracker(false);
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(petDTO)))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void listPetsAndCountPets_ShouldReturnListOfPetsAndCount() throws Exception {
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Dog", 1L, "Medium", true, null))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Cat", 2L, "Small", false, true))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Dog", 3L, "Medium", true, null))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("cat", 4L, "Big", false, true))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Dog", 5L, "Medium", false, null))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("cat", 6L, "Small", false, true))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Dog", 7L, "Medium", false, null))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Cat", 8L, "Big", true, true))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("Dog", 9L, "Medium", true, null))))
                .andExpect(status().isOk());
        mockMvc.perform(post("/api/pets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PetDTO("cat", 10L, "Small", true, true))))
                .andExpect(status().isOk());
        mockMvc.perform(get("/api/pets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(10));
        mockMvc.perform(get("/api/pets/count?inZone=false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.count").value(5));
    }
}

