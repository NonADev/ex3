package com.pets.application.controllers;

import com.google.gson.Gson;
import com.pets.domain.models.Pet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping
public class PetController {
    @CrossOrigin
    @GetMapping("/pets")
    public ResponseEntity<Object> pets() {
        try {
            return ResponseEntity.ok("toto<br>richard<br>mateus");
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/lista")
    public ResponseEntity<Object> lista() {
        try {
            Pet[] p = new Pet[3];
            for(int i = 0; i<3;i++){
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
