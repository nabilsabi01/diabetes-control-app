package com.diabetes.control.repository;

import com.diabetes.control.model.PhysicalActivity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PhysicalActivityRepository extends JpaRepository<PhysicalActivity, Long> {
    List<PhysicalActivity> findByUserId(Long userId);
}
