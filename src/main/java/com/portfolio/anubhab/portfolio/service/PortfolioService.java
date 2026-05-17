package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.model.Project;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PortfolioService {

    public List<Project> getProjects() {
        List<Project> projects = new ArrayList<>();
        projects.add(new Project("Event-Driven Kafka Processing System",
                "Event-driven backend system using Apache Kafka for real-time message processing.",
                "image1.jpg"));
        projects.add(new Project("AI-Powered Portfolio Assistant",
                "AI-powered portfolio platform with chatbot integration and intelligent query handling.",
                "image2.jpg"));
        return projects;
    }
}
