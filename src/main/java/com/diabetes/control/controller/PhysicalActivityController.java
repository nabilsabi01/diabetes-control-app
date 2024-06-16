package com.diabetes.control.controller;

import com.diabetes.control.model.PhysicalActivity;
import com.diabetes.control.service.PhysicalActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/activities")
public class PhysicalActivityController {

    @Autowired
    private PhysicalActivityService activityService;

    @GetMapping("/{userId}")
    public String getAllActivitiesForUser(@PathVariable Long userId, Model model) {
        model.addAttribute("activities", activityService.getAllActivitiesForUser(userId));
        model.addAttribute("userId", userId);
        return "activities";
    }

    @GetMapping("/new/{userId}")
    public String showCreateActivityForm(@PathVariable Long userId, Model model) {
        model.addAttribute("activity", new PhysicalActivity());
        model.addAttribute("userId", userId);
        return "add-activity";
    }

    @PostMapping("/new/{userId}")
    public String createActivity(@ModelAttribute("activity") PhysicalActivity activity, @PathVariable Long userId) {
        activityService.createActivity(activity, userId);
        return "redirect:/activities/" + userId;
    }

    @GetMapping("/edit/{id}")
    public String showEditActivityForm(@PathVariable Long id, Model model) {
        PhysicalActivity activity = activityService.getActivityById(id)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
        model.addAttribute("activity", activity);
        return "edit-activity";
    }

    @PostMapping("/edit/{id}")
    public String updateActivity(@PathVariable Long id, @ModelAttribute("activity") PhysicalActivity activity) {
        activityService.updateActivity(id, activity);
        Long userId = activityService.getUserIdForActivity(id);
        return "redirect:/activities/" + userId;
    }

    @GetMapping("/delete/{id}")
    public String deleteActivity(@PathVariable Long id) {
        Long userId = activityService.getUserIdForActivity(id);
        activityService.deleteActivity(id);
        return "redirect:/activities/" + userId;
    }
}
