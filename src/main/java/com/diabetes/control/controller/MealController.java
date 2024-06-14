package com.diabetes.control.controller;

import com.diabetes.control.model.Meal;
import com.diabetes.control.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/meals")
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("/new/{userId}")
    public String showCreateMealForm(@PathVariable Long userId, Model model) {
        model.addAttribute("meal", new Meal());
        model.addAttribute("userId", userId);
        return "meal-form";
    }

    @PostMapping("/new/{userId}")
    public String createMeal(@ModelAttribute("meal") Meal meal, @PathVariable Long userId) {
        mealService.createMeal(meal, userId);
        return "redirect:/meals/list/" + userId;
    }

    @GetMapping("/list/{userId}")
    public String getAllMealsForUser(@PathVariable Long userId, Model model) {
        model.addAttribute("meals", mealService.getAllMealsForUser(userId));
        model.addAttribute("userId", userId);
        return "meal-list";
    }

    @GetMapping("/edit/{id}")
    public String showEditMealForm(@PathVariable Long id, Model model) {
        Meal meal = mealService.getMealById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found"));
        model.addAttribute("meal", meal);
        return "edit-meal";
    }

    @PostMapping("/edit/{id}")
    public String updateMeal(@PathVariable Long id, @ModelAttribute("meal") Meal meal) {
        mealService.updateMeal(id, meal);
        return "redirect:/meals/list/" + meal.getUser().getId();
    }
}
