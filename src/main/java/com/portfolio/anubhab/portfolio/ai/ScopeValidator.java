package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class ScopeValidator {

    public boolean isInScope(String question) {

        if (question == null || question.isBlank()) {
            return false;
        }
        
        String q = question.toLowerCase();
        if (q.matches(".*\\b(thanks|thank you|ok|okay|cool|great)\\b.*")) {
                return true;
            }

        

        // Main portfolio-related keywords
        boolean directMatch =
                q.contains("anubhab")
                || q.contains("skill")
                || q.contains("experience")
                || q.contains("project")
                || q.contains("kafka")
                || q.contains("backend")
                || q.contains("java")
                || q.contains("spring")
                || q.contains("portfolio")
                || q.contains("developer")
                || q.contains("technology")
                || q.contains("tech stack")
                || q.contains("tcs")
                || q.contains("persistent")
                || q.contains("salesforce")
                || q.contains("splunk")
                || q.contains("microservice")
                || q.contains("api")
                || q.contains("hire")
                || q.contains("database")
                || q.contains("postgresql")
                || q.contains("mysql")
                || q.contains("tools")
                || q.contains("framework")
                || q.contains("stack")
                || q.contains("technology")
                || q.contains("technologies");

        // Follow-up conversational questions
      boolean followUp =
        q.contains("there")
        || q.contains("that")
        || q.contains("those")
        || q.contains("it")
        || q.contains("them")
        || q.contains("more")
        || q.contains("explain")
        || q.contains("how")
        || q.contains("why")
        || q.contains("he")
        || q.contains("his")
        || q.contains("him")
        || q.contains("know")
        || q.contains("knows")
        || q.contains("what technologies")
        || q.contains("what tools")
        || q.contains("tell me more")
        || q.contains("who are you")
        || q.contains("your role")
        || q.contains("what are you")
        || q.contains("what can you do")
        || q.contains("thanks")
        || q.contains("thank you")
        || q.contains("okay")
        || q.contains("cool")
        || q.contains("great");

        return directMatch || followUp;
    }

    public String outOfScopeMessage() {

        return """
        I can only answer questions related to
        Anubhab Chattopadhyay’s portfolio,
        projects, experience, and technical background.
        """;
    }
}