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
    @Column(name = "mealId")
    private Long mealId;

    @Column(name = "mealName")
    private String mealName;

    private String mealType;

    @Column(name = "mealDescription")
    private String mealDescription;

    private String mealImage;

    @Column(name = "Carbs")
    private Integer carbs;

    @Column(name = "Kcal")
    private Integer kcal;
}
