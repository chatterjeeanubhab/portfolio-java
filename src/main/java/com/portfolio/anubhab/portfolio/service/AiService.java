package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.ai.AiClient;
import com.portfolio.anubhab.portfolio.ai.PromptBuilder;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final AiClient aiClient;

    public AiService(AiClient aiClient) {
        this.aiClient = aiClient;
    }

    public String getAnswer(String question) {

        if (question == null || question.trim().isEmpty()) {
            return "Please ask a valid question about Anubhab.";
        }

        String prompt = PromptBuilder.buildPrompt(question);

        return aiClient.ask(prompt);
    }
}
