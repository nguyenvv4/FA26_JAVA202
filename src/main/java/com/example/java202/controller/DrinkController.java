package com.example.java202.controller;

import com.example.java202.model.Drink;
import com.example.java202.repo.DrinkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrinkController {

    @Autowired
    DrinkRepo drinkRepo;

    @GetMapping("/drinks")
    public List<Drink> getAll() {
        return drinkRepo.findAll();
    }

    @PostMapping("/add/drinks")
    public String addNewDrink(@RequestBody Drink drink) {
        drinkRepo.save(drink);
        return "Them thanh cong";
    }

    @DeleteMapping("/delete/drinks")
    public String deleteDrink(@RequestParam("id") Integer id) {
        drinkRepo.deleteById(id);
        return "Xoa thanh cong";
    }

    @PutMapping("/update/drinks")
    public String updateDrink(@RequestBody Drink newDrink, @RequestParam("id") Integer id) {
        Drink drinkCurrent = drinkRepo.findById(id).get();
        drinkCurrent.setName(newDrink.getName());
        drinkCurrent.setImage(newDrink.getImage());
        drinkCurrent.setActive(newDrink.getActive());
        drinkCurrent.setCategoryId(newDrink.getCategoryId());
        drinkCurrent.setDescription(newDrink.getDescription());
        drinkCurrent.setPrice(newDrink.getPrice());
        drinkRepo.save(drinkCurrent);
        return "Update thanh cong";
    }
}
