package com.example.java202.repo;

import com.example.java202.model.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrinkRepo extends JpaRepository<Drink, Integer> {
}
