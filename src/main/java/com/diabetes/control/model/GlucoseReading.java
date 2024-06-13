package com.diabetes.control.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class GlucoseReading {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double level;

    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    private GlucoseLevel glucoseLevel;

    @PrePersist
    @PreUpdate
    private void updateGlucoseLevel() {
        this.glucoseLevel = GlucoseLevel.fromLevel(this.level);
    }
}
