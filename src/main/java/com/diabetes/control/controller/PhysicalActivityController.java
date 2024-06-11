package com.diabetes.control.controller;

import com.diabetes.control.model.PhysicalActivity;
import com.diabetes.control.service.PhysicalActivityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/activities")
public class PhysicalActivityController {

    private final PhysicalActivityService physicalActivityService;

    public PhysicalActivityController(PhysicalActivityService physicalActivityService) {
        this.physicalActivityService = physicalActivityService;
    }

    @GetMapping
    public String getAllActivities(Model model) {
        Long userId = getCurrentUserId(); // Get the current user's ID
        List<PhysicalActivity> activities = physicalActivityService.findAllByUserId(userId);
        model.addAttribute("activities", activities);
        return "physical-activity";
    }

    @GetMapping("/new")
    public String showNewActivityForm(Model model) {
        model.addAttribute("activity", new PhysicalActivity());
        return "activity-form";
    }

    private Long getCurrentUserId() {
        return 1L;
    }
}