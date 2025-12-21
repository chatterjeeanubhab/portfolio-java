package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class ScopeValidator {

    public boolean isInScope(String question) {
        if (question == null) return false;

        String q = question.toLowerCase();

        return q.contains("anubhab")
                || q.contains("skill")
                || q.contains("experience")
                || q.contains("project")
                || q.contains("kafka")
                || q.contains("backend")
                || q.contains("hire");
    }

    public String outOfScopeMessage() {
        return "I can only answer questions related to Anubhab Chattopadhyay’s professional profile and portfolio.";
    }
}
