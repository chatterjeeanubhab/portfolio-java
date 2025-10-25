package com.portfolio.anubhab.portfolio.controller;

import com.portfolio.anubhab.portfolio.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/experience")
public class ExperienceController {

    @GetMapping
    public String experienceHome(Model model) {
        // Load list of experiences (titles + company names)
        // Pass to view if dynamic, or static in template if fixed
        return "experience"; // main experience page template
    }

    @GetMapping("/software-engineer")
    public String softwareEngineerDetail(Model model) {
        model.addAttribute("role", "Software Engineer");
        model.addAttribute("company", "Tata Consultancy Services");
        model.addAttribute("dates", "OCT 2024 - Present");
        model.addAttribute("description", "Worked on Spring Boot projects and REST APIs.");
        return "experience-detail";
    }

    @GetMapping("/java-developer")
    public String javaDeveloperDetail(Model model) {
        model.addAttribute("role", "Java Developer");
        model.addAttribute("company", "Persistent Systems");
        model.addAttribute("dates", "Jun 2023 - Aug 2023");
        model.addAttribute("description", "Built and maintained microservices in Java and Spring.");
        return "experience-detail";
    }
}

