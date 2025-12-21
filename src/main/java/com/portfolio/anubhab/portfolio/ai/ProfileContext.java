package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class ProfileContext {

    public String getProfile() {
        return """
        PROFILE FACTS (SOURCE OF TRUTH):

        Name: Anubhab Chattopadhyay
        Role: Java & Spring Boot Backend Developer

        Core Skills:
        - Java (Core Java, Collections, Streams)
        - Spring Boot (REST APIs, MVC, JPA, Security basics)
        - Apache Kafka (Source & Sink connectors, message flow understanding)
        - REST API design & backend integration
        - PostgreSQL
        - Microservices fundamentals

        Experience Focus:
        - Backend-focused engineering
        - Kafka-based data pipelines
        - API integrations between systems
        - Clean architecture & maintainable code
        Work Experience:
        - Java Developer,Tata Consultancy Services (TCS) - Backend development & system integration
        - Open Source contributor - Java & Spring Boot projects
        -Intern at Persistent Systems - Worked on SpringBoot microservices
        Academic Background:
        - B.Tech in Computer Science & Engineering, Academy of Technology, Kolkata
        - Graduated 2024
        -first class with distinction

        Projects:
        - Portfolio website with AI assistant (Spring Boot + OpenRouter)
        - Backend services using Spring Boot & Kafka
        - System integration projects involving message-driven architecture

        Work Style:
        - Strong problem-solving mindset
        - Learns by building real systems
        - Focus on scalability and clarity

        IMPORTANT RULES:
        - Do NOT add companies, years, or tools not listed above
        - Do NOT exaggerate experience
        - If information is missing, say it is not publicly listed
        """;
    }
}
