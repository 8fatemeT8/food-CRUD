package com.example.demo.controller;

import com.example.demo.Utils.*;
import com.example.demo.function.BaseMethod;
import com.example.demo.model.Food;
import com.example.demo.repository.FoodModelRepositoryCustom;
import com.example.demo.repository.FoodRepository;
import com.example.demo.servis.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/api/food")
public class FoodController extends BaseMethod {
    private Service service;

    public FoodController(FoodModelRepositoryCustom mfR, FoodRepository menuFoodRepository) {
        this.service = new Service(menuFoodRepository, mfR);
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody Food foodInfo) {
        return service.create(foodInfo) ? ResponseEntity.ok().body("") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestParam("id") int id) {
        return service.deleteById(id) ? ResponseEntity.ok().body("") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @PutMapping
    public ResponseEntity update(@RequestBody Food foodUpdateJson) {
        return service.update(foodUpdateJson) ? ResponseEntity.ok().body("") : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("");
    }

    @GetMapping
    public ResponseEntity<MenuJson> food(@RequestBody FoodSearchJson parentJson){
        return ResponseEntity.ok(service.food(parentJson));
    }

}
