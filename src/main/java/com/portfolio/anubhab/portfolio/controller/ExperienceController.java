package com.portfolio.anubhab.portfolio.controller;

import com.portfolio.anubhab.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExperienceController {

    @Autowired
    private ExperienceService experienceService;

    @GetMapping("/experience")
    public String experiencePage(Model model) {
        model.addAttribute("experiences", experienceService.getExperiences());
        return "experience";
    }
}
