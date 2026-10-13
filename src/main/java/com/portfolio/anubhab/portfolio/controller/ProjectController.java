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
@GetMapping("/notes")
public String notesService(Model model) {

    model.addAttribute(
            "projectTitle",
            "Notes Service"
    );

    model.addAttribute(
            "projectType",
            "Spring Boot REST API for Note Management"
    );

    model.addAttribute(
            "description",
            "Developed a backend application to create, retrieve, update, delete, and search notes using Spring Boot, Spring Data JPA, and MySQL."
    );

    model.addAttribute(
            "architectureFlow",
            "Client → REST Controller → Service Layer → Repository → Spring Data JPA → MySQL"
    );

    model.addAttribute(
            "contributions",
            List.of(
                    "Implemented REST APIs for creating, retrieving, updating, deleting, and searching notes.",
                    "Designed a layered architecture using Controller, Service, and Repository components.",
                    "Implemented DTO-based request and response handling with a dedicated mapper layer.",
                    "Added input validation and global exception handling with standardized error responses.",
                    "Implemented JPA auditing to automatically maintain creation and modification timestamps.",
                    "Added pagination, sorting, and search functionality using Spring Data JPA.",
                    "Integrated Swagger/OpenAPI for API documentation and tested endpoints using Postman."
            )
    );

    model.addAttribute(
            "techStack",
            List.of(
                    "Java",
                    "Spring Boot",
                    "Spring Data JPA",
                    "Hibernate",
                    "MySQL",
                    "REST APIs",
                    "Bean Validation",
                    "Swagger/OpenAPI",
                    "Maven",
                    "Postman",
                    "Git"
            )
    );

    return "project-details";
}
@GetMapping("/eventbridgex")
public String eventBridgeX(Model model) {

    model.addAttribute(
            "projectTitle",
            "EventBridgeX"
    );

    model.addAttribute(
            "projectType",
            "Event-Driven Architecture using Spring Boot and Apache Kafka"
    );

    model.addAttribute(
            "description",
            "Developed an event-driven application using Spring Boot and Apache Kafka, implementing separate producer and consumer services to publish and process user events asynchronously."
    );

    model.addAttribute(
            "architectureFlow",
            "Client → Producer Service → Kafka Topic (user-events) → Consumer Service"
    );

    model.addAttribute(
            "contributions",
            List.of(
                    "Developed separate Spring Boot producer and consumer services for asynchronous event processing.",
                    "Implemented a REST API (POST /users) to publish USER_CREATED events to Kafka.",
                    "Configured the user-events Kafka topic with three partitions for distributed event processing.",
                    "Implemented event consumption using @KafkaListener with the user-group consumer group.",
                    "Designed event models and payload classes to structure user-related event data.",
                    "Configured Kafka connectivity and service orchestration using Docker Compose.",
                    "Tested event publishing and consumption to validate the end-to-end event flow."
            )
    );

    model.addAttribute(
            "techStack",
            List.of(
                    "Java",
                    "Spring Boot",
                    "Apache Kafka",
                    "Apache Kafka Producer API",
                    "Spring Kafka",
                    "REST APIs",
                    "Docker",
                    "Docker Compose",
                    "Maven",
                    "Postman",
                    "Git"
            )
    );

    return "project-details";
}
}