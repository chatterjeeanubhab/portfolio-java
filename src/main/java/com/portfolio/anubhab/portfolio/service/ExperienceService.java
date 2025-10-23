package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.model.Experience;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExperienceService {

    public List<Experience> getExperiences() {
        List<Experience> experiences = new ArrayList<>();

        experiences.add(new Experience("Tata Consultancy Services", "Software Engineer", "OCT 2024  - Present", "Worked on Spring Boot projects and REST APIs."));
        experiences.add(new Experience("Persistent Systems", "Java Developer", "Jun 2023 - Aug 2023", "Built and maintained microservices in Java and Spring."));

        return experiences;
    }
}
