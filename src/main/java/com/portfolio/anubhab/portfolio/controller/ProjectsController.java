package com.portfolio.anubhab.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProjectsController {

    @GetMapping("/projects")
    public String projectsPage() {
        return "projects"; // matches projects.html
    }
}
