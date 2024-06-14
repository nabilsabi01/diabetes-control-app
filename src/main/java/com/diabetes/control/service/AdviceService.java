package com.diabetes.control.service;

import com.diabetes.control.model.Advice;
import com.diabetes.control.model.GlucoseLevel;
import com.diabetes.control.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdviceService {
    @Autowired
    private AdviceRepository adviceRepository;

    public String getAdviceMessage(Double glucoseLevel) {
        GlucoseLevel level = GlucoseLevel.fromLevel(glucoseLevel);
        Advice advice = adviceRepository.findByGlucoseLevel(level);
        return advice.getMessage();
    }
}