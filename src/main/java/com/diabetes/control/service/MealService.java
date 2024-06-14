//package com.diabetes.control.service;
//
//import com.diabetes.control.model.Meal;
//import com.diabetes.control.repository.MealRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class MealService {
//
//    @Autowired
//    private MealRepository mealRepository;
//
//    public List<Meal> getAllMeals() {
//        return mealRepository.findAll();
//    }
//
//    public Optional<Meal> getMealById(Long mealId) {
//        return mealRepository.findById(mealId);
//    }
//
//    public Meal saveMeal(Meal meal) {
//        return mealRepository.save(meal);
//    }
//
//    public void deleteMeal(Long mealId) {
//        mealRepository.deleteById(mealId);
//    }
//}
package com.diabetes.control.service;

import com.diabetes.control.model.Meal;
import com.diabetes.control.model.User;
import com.diabetes.control.repository.MealRepository;
import com.diabetes.control.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Meal> getAllMealsForUser(Long userId) {
        return mealRepository.findByUserId(userId);
    }

    public Optional<Meal> getMealById(Long id) {
        return mealRepository.findById(id);
    }

    public void createMeal(Meal meal, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        meal.setUser(user);
        mealRepository.save(meal);
    }

    public void updateMeal(Long id, Meal updatedMeal) {
        Meal meal = mealRepository.findById(id).orElseThrow(() -> new RuntimeException("Meal not found"));
        meal.setMealName(updatedMeal.getMealName());
        meal.setMealDescription(updatedMeal.getMealDescription());
        meal.setCarbs(updatedMeal.getCarbs());
        meal.setKcal(updatedMeal.getKcal());
        mealRepository.save(meal);
    }

    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
}
