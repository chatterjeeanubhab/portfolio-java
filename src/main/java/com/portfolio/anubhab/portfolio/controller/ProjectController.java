package com.portfolio.anubhab.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @GetMapping("/kafka")
    public String kafkaProject(Model model) {

        model.addAttribute(
                "projectTitle",
                "Event-Driven Salesforce Kafka Integration Platform"
        );

        model.addAttribute(
                "projectType",
                "Enterprise Event Streaming System"
        );

        model.addAttribute(
                "description",
                "Designed and enhanced an event-driven integration platform connecting Salesforce and Confluent Kafka using Java-based source and sink connector applications."
        );

        model.addAttribute(
                "architectureFlow",
                "Salesforce → Platform Events / Push Topics → Kafka Connector → Java Source Connect Application → Confluent Kafka Topic"
        );

        model.addAttribute(
                "contributions",
                List.of(
                        "Developed and maintained Java-based source and sink connector applications for Salesforce-Kafka integration.",
                        "Implemented a custom retry mechanism for failed events to ensure reliable delivery to Kafka topics.",
                        "Built automated connector restart workflows using Splunk webhook integrations for failure recovery.",
                        "Worked on real-time event streaming pipelines using Apache Kafka and Confluent Platform.",
                        "Participated in production issue debugging, monitoring, and reliability improvements."
                )
        );

        model.addAttribute(
                "techStack",
                List.of(
                        "Java",
                        "Spring Boot",
                        "Apache Kafka",
                        "Confluent Kafka",
                        "Salesforce",
                        "Splunk",
                        "REST APIs"
                )
        );

        return "project-details";
    }

    @GetMapping("/portfolio")
    public String portfolioProject(Model model) {

        model.addAttribute(
                "projectTitle",
                "AI-Powered Portfolio Assistant"
        );

        model.addAttribute(
                "projectType",
                "AI Integrated Web Platform"
        );

        model.addAttribute(
                "description",
                "Developed an interactive AI-powered portfolio platform with chatbot integration capable of answering project, experience, and technical queries dynamically."
        );

        model.addAttribute(
                "architectureFlow",
                "User → Portfolio UI → Spring Boot Backend → OpenRouter API → AI Response"
        );

        model.addAttribute(
                "contributions",
                List.of(
                        "Integrated AI chatbot capabilities using OpenRouter APIs.",
                        "Developed responsive frontend using HTML, CSS, and Thymeleaf.",
                        "Implemented intelligent query handling for projects and experience sections.",
                        "Built Spring Boot backend APIs for chatbot communication.",
                        "Designed dynamic UI components for an interactive portfolio experience."
                )
        );

        model.addAttribute(
                "techStack",
                List.of(
                        "Java",
                        "Spring Boot",
                        "Thymeleaf",
                        "HTML",
                        "CSS",
                        "JavaScript",
                        "OpenRouter API"
                )
        );

        return "project-details";
    }
}