package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.ai.OpenRouterClient;
import org.springframework.stereotype.Service;

@Service
public class AiService {

    private final OpenRouterClient openRouterClient;

    public AiService(OpenRouterClient openRouterClient) {
        this.openRouterClient = openRouterClient;
    }

    public String getAnswer(String question) {
        return openRouterClient.ask(question);
    }
}
