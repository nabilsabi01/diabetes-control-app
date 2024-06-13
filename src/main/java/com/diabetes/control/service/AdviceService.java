<<<<<<< HEAD
package com.diabetes.control.service;

public interface AdviceService {
=======
package com.diabetes.control.service.impl;

import com.diabetes.control.model.Advice;
import com.diabetes.control.repository.AdviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdviceService {

    @Autowired
    private AdviceRepository adviceRepository;

    public List<String> getAdviceForValue(double value) {
        List<String> advices = new ArrayList<>();


        advices.addAll(adviceRepository.findByValueBetween(0, 0.5).stream()
                .map(Advice::getMessage)
                .toList());

        advices.addAll(adviceRepository.findByValueBetween(0.5, 1.0).stream()
                .map(Advice::getMessage)
                .toList());

        advices.addAll(adviceRepository.findByValueBetween(1.0, 1.5).stream()
                .map(Advice::getMessage)
                .toList());

        advices.addAll(adviceRepository.findByValueBetween(1.5, 2.0).stream()
                .map(Advice::getMessage)
                .toList());

        return advices;
    }
>>>>>>> 96fafc3048fdc65caf123a151fde8c4079ba0a49
}
