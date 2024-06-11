package com.diabetes.control.service;

import com.diabetes.control.model.PhysicalActivity;
import com.diabetes.control.repository.PhysicalActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PhysicalActivityServiceImpl implements PhysicalActivityService {
    private final PhysicalActivityRepository physicalActivityRepository;

    public PhysicalActivityServiceImpl(PhysicalActivityRepository physicalActivityRepository) {
        this.physicalActivityRepository = physicalActivityRepository;
    }

    @Override
    public PhysicalActivity save(PhysicalActivity physicalActivity) {
        return physicalActivityRepository.save(physicalActivity);
    }

    @Override
    public List<PhysicalActivity> findAllByUserId(Long userId) {
        return physicalActivityRepository.findByUserId(userId);
    }

    @Override
    public PhysicalActivity findById(Long id) {
        return physicalActivityRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        physicalActivityRepository.deleteById(id);
    }
}