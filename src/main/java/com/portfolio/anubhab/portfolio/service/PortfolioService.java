package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.model.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Personal Portfolio", "My Spring Boot portfolio website with custom styling.", "image1.jpg"));
        projects.add(new Project("Weather App", "A Java web app that shows live weather data using API.", "image2.jpg"));
        return projects;
    }
}
