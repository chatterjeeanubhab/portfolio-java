package com.portfolio.anubhab.portfolio.controller;

import com.portfolio.anubhab.portfolio.model.Project;
import com.portfolio.anubhab.portfolio.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @GetMapping("/projects")
    public String projectsPage(Model model) {
        List<Project> projects = portfolioService.getProjects();
        model.addAttribute("projects", projects);
        return "projects";
    }
}
