package com.diabetes.control.controller;

import com.diabetes.control.model.GlucoseLevel;
import com.diabetes.control.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/advice")
public class AdviceController {
    @Autowired
    private AdviceService adviceService;

    @GetMapping("/{glucoseLevel}")
    public String getAdvice(@PathVariable Double glucoseLevel, Model model) {
        String adviceMessage = adviceService.getAdviceMessage(glucoseLevel);
        GlucoseLevel level = GlucoseLevel.fromLevel(glucoseLevel);

        model.addAttribute("glucoseLevel", level.getDisplayName());
        model.addAttribute("adviceMessage", adviceMessage);

        return "advice";
    }
}
