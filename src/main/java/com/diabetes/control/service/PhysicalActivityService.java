package com.diabetes.control.service;

import com.diabetes.control.model.PhysicalActivity;

import java.util.List;

public interface PhysicalActivityService {
    PhysicalActivity save(PhysicalActivity physicalActivity);
    List<PhysicalActivity> findAllByUserId(Long userId);
    PhysicalActivity findById(Long id);
    void deleteById(Long id);
}