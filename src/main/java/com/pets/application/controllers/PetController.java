package com.pets.application.controllers;

import com.google.gson.Gson;
import com.pets.domain.models.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping
public class PetController {
    static ArrayList<Pet> petList = new ArrayList<>();

    @GetMapping("/pets")
    public ResponseEntity<Object> pets() {
        try {
            return ResponseEntity.ok(petList);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/pets")
    public ResponseEntity<Object> insertPet(@RequestBody Pet newPet) {
        try {
            petList.add(newPet);
            return ResponseEntity.ok(petList.get(petList.size()-1));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<Object> lista() {
        try {
            Pet[] p = new Pet[3];
            for (int i = 0; i < 3; i++) {
                p[i] = new Pet();
            }
            p[0].nome = "toto";
            p[1].nome = "richard";
            p[2].nome = "mateus";
            Gson gson = new Gson();
            return ResponseEntity.ok(gson.toJson(p));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
