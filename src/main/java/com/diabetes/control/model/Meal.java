package com.diabetes.control.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "meal")
@Getter
@Setter
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long mealId;

    private String mealName;

    private String mealType;

    @Column(name = "meal_description")
    private String mealDescription;

    @Column(name = "meal_image")
    private String mealImage;

    @Column(name = "Carbs")
    private Integer carbs;

    @Column(name = "kcal")
    private Integer kcal;
}
