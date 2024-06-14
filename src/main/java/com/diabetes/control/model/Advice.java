package com.diabetes.control.model;

import jakarta.persistence.*;

@Entity
@Table(name = "advice")
public class Advice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "glucose_level")
    private GlucoseLevel glucoseLevel;

    @Column(name = "message")
    private String message;

    // Default constructor
    public Advice() {
    }

    // Constructor with parameters
    public Advice(GlucoseLevel glucoseLevel, String message) {
        this.glucoseLevel = glucoseLevel;
        this.message = message;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GlucoseLevel getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(GlucoseLevel glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}