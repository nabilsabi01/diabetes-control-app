package com.diabetes.control.repository;

import com.diabetes.control.model.GlucoseReading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GlucoseReadingRepository extends JpaRepository<GlucoseReading, Long> {
}
