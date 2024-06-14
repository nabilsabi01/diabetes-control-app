package com.diabetes.control.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.LocalDateTime;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "physical_activities")
public class PhysicalActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_type")
    private ActivityType activityType;
    private Double duration;
    @Column(name = "start_date_time")
    private LocalDateTime startDateTime;
    @Column(name = "end_date_time")
    private LocalDateTime endDateTime;
    private String notes;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}