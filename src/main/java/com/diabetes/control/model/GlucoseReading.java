package com.diabetes.control.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GlucoseReading {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double level;
    private LocalDateTime timestamp;
    @Enumerated(EnumType.STRING)
    @Column(name = "glucose_level")
    private GlucoseLevel glucoseLevel;
    @PrePersist
    @PreUpdate
    private void updateGlucoseLevel() {
        this.glucoseLevel = GlucoseLevel.fromLevel(this.level);
    }
}
