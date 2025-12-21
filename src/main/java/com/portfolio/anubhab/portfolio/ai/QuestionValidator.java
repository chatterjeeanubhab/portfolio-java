package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QuestionValidator {

    private static final List<String> ALLOWED_KEYWORDS = List.of(
            "anubhab",
            "portfolio",
            "experience",
            "skills",
            "java",
            "spring",
            "spring boot",
            "kafka",
            "backend",
            "projects",
            "developer",
            "hire",
            "hiring"
    );

    public boolean isAllowed(String question) {
        String lower = question.toLowerCase();

        return ALLOWED_KEYWORDS.stream()
                .anyMatch(lower::contains);
    }
}
