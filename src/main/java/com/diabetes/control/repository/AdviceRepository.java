package com.diabetes.control.repository;

import com.diabetes.control.model.Advice;
import com.diabetes.control.model.GlucoseLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdviceRepository extends JpaRepository<Advice, Long> {
    Advice findByGlucoseLevel(GlucoseLevel glucoseLevel);
}