package com.portfolio.anubhab.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/experience")
public class ExperienceController {

    @GetMapping
    public String experienceHome(Model model) {
        return "experience";
    }

    @GetMapping("/Java-Developer")
    public String javaDeveloperDetail(Model model) {

        model.addAttribute(
                "role",
                "Java Developer"
        );

        model.addAttribute(
                "company",
                "Tata Consultancy Services"
        );

        model.addAttribute(
                "dates",
                "OCT 2024 - Present"
        );

        model.addAttribute(
                "summary",
                "Worked as a backend developer on enterprise-scale event-driven systems involving Salesforce, Apache Kafka, and Java-based connector applications."
        );

        model.addAttribute(
                "responsibilities",
                List.of(
                        "Developed and enhanced source and sink connector applications using Java and Spring Boot.",
                        "Worked on real-time event streaming pipelines using Apache Kafka and Confluent Platform.",
                        "Implemented retry mechanisms for failed event processing to improve reliability.",
                        "Built automated connector restart workflows integrated with Splunk webhooks.",
                        "Participated in production issue debugging, monitoring, and reliability improvements.",
                        "Collaborated with cross-functional teams for integration and deployment activities."
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
                        "REST APIs",
                        "Git"
                )
        );

        model.addAttribute(
                "achievements",
                List.of(
                        "Improved event delivery reliability through custom retry handling.",
                        "Reduced manual intervention by automating connector restart processes.",
                        "Contributed to production-grade event streaming systems handling real-time integrations."
                )
        );

        return "experience-detail";
    }

    @GetMapping("/Summer-Intern")
    public String summerInternDetail(Model model) {

        model.addAttribute(
                "role",
                "Summer Intern"
        );

        model.addAttribute(
                "company",
                "Persistent Systems"
        );

        model.addAttribute(
                "dates",
                "Jun 2023 - Aug 2023"
        );

        model.addAttribute(
                "summary",
                "Completed training focused on Java backend development, Spring Boot fundamentals, REST APIs, and software development best practices."
        );

        model.addAttribute(
                "responsibilities",
                List.of(
                        "Received hands-on training in Java and Spring Boot application development.",
                        "Worked on REST API fundamentals and backend development concepts.",
                        "Practiced object-oriented programming and Java collections framework concepts.",
                        "Participated in coding exercises, debugging sessions, and technical learning modules.",
                        "Learned software development workflows and collaborative development practices."
                )
        );

        model.addAttribute(
                "techStack",
                List.of(
                        "Java",
                        "Spring Boot",
                        "REST APIs",
                        "MySQL",
                        "Git"
                )
        );

        model.addAttribute(
                "achievements",
                List.of(
                        "Successfully completed backend development training program.",
                        "Strengthened understanding of Java and Spring Boot development fundamentals."
                )
        );

        return "experience-detail";
    }
}