package com.diabetes.control.service;

import com.diabetes.control.model.GlucoseReading;
import com.diabetes.control.repository.GlucoseReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GlucoseReadingService {

    @Autowired
    private GlucoseReadingRepository repository;

    public List<GlucoseReading> getAllReadings() {
        return repository.findAll();
    }

    public GlucoseReading getReadingById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public GlucoseReading saveReading(GlucoseReading reading) {
        return repository.save(reading);
    }

    public void deleteReading(Long id) {
        repository.deleteById(id);
    }
}
