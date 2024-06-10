package com.diabetes.control.service;

import com.diabetes.control.model.PhysicalActivity;
import com.diabetes.control.repository.PhysicalActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhysicalActivityService {
    @Autowired
    private PhysicalActivityRepository repository;

    public List<PhysicalActivity> getAllActivitiesByUserId(Long userId) {
        return repository.findByUserId(userId);
    }

    public void saveActivity(PhysicalActivity activity) {
        repository.save(activity);
    }
}
