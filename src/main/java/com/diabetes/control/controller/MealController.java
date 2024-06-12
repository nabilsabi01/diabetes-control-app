package com.diabetes.control.controller;

import com.diabetes.control.model.Meal;
import com.diabetes.control.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meal> getMealById(@PathVariable Long id) {
        Optional<Meal> meal = mealService.getMealById(id);
        if (meal.isPresent()) {
            return ResponseEntity.ok(meal.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Meal createMeal(@RequestBody Meal meal) {
        return mealService.saveMeal(meal);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meal> updateMeal(@PathVariable Long id, @RequestBody Meal mealDetails) {
        Optional<Meal> meal = mealService.getMealById(id);
        if (meal.isPresent()) {
            Meal updatedMeal = meal.get();
            updatedMeal.setMealName(mealDetails.getMealName());
            updatedMeal.setMealDescription(mealDetails.getMealDescription());
            updatedMeal.setCarbs(mealDetails.getCarbs());
            updatedMeal.setKcal(mealDetails.getKcal());
            return ResponseEntity.ok(mealService.saveMeal(updatedMeal));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
        return ResponseEntity.noContent().build();
    }
}
