package com.diabetes.control.controller;

import com.diabetes.control.model.GlucoseReading;
import com.diabetes.control.service.GlucoseReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/readings")
public class GlucoseReadingController {

    @Autowired
    private GlucoseReadingService service;

    @GetMapping
    public String listReadings(Model model) {
        model.addAttribute("readings", service.getAllReadings());
        return "readings/list";
    }

    @GetMapping("/new")
    public String showNewReadingForm(Model model) {
        model.addAttribute("reading", new GlucoseReading());
        return "readings/form";
    }

    @PostMapping
    public String saveReading(@ModelAttribute GlucoseReading reading) {
        service.saveReading(reading);
        return "redirect:/readings";
    }

    @GetMapping("/edit/{id}")
    public String showEditReadingForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("reading", service.getReadingById(id));
        return "readings/form";
    }

    @PostMapping("/{id}")
    public String updateReading(@PathVariable("id") Long id, @ModelAttribute GlucoseReading reading) {
        reading.setId(id);
        service.saveReading(reading);
        return "redirect:/readings";
    }

    @GetMapping("/delete/{id}")
    public String deleteReading(@PathVariable("id") Long id) {
        service.deleteReading(id);
        return "redirect:/readings";
    }
}
