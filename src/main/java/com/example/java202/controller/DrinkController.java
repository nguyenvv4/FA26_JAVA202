package com.example.java202.controller;

import com.example.java202.model.Drink;
import com.example.java202.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DrinkController {

    @Autowired
    DrinkRepo drinkRepo;

    @GetMapping("/drinks")
    public List<Drink> getAll() {
        return drinkRepo.findAll();
    }
}
