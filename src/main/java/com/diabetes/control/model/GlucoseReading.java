package com.diabetes.control.model;

import jakarta.persistence.*;

@Entity
@Table(name = "glucose_reading")
public class GlucoseReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "level")
    private Double level;

    @Column(name = "timestamp")
    private String timestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "glucose_level")
    private GlucoseLevel glucoseLevel;

    @ManyToOne
    @JoinColumn(name = "glucose_level", referencedColumnName = "glucose_level", insertable = false, updatable = false)
    private Advice advice;

    // Default constructor
    public GlucoseReading() {
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLevel() {
        return level;
    }

    public void setLevel(Double level) {
        this.level = level;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public GlucoseLevel getGlucoseLevel() {
        return glucoseLevel;
    }

    public void setGlucoseLevel(GlucoseLevel glucoseLevel) {
        this.glucoseLevel = glucoseLevel;
    }

    public Advice getAdvice() {
        return advice;
    }

    public void setAdvice(Advice advice) {
        this.advice = advice;
    }
}
