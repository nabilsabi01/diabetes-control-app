package com.diabetes.control.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "meal")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mealId;

    private String mealName;
    private String mealType;
    private String mealDescription;
    private String mealImage;
    private Integer carbs;
    private Integer kcal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
