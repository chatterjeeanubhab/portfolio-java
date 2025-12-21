package com.portfolio.anubhab.portfolio.service;


import com.portfolio.anubhab.portfolio.ai.OpenRouterClient;
import com.portfolio.anubhab.portfolio.ai.PromptBuilder;
import com.portfolio.anubhab.portfolio.ai.ScopeValidator;
import org.springframework.stereotype.Service;
import com.portfolio.anubhab.portfolio.ai.ResponseParser;
import com.portfolio.anubhab.portfolio.ai.ResponseSanitizer;
import com.portfolio.anubhab.portfolio.ai.ConversationMemory;
import com.portfolio.anubhab.portfolio.ai.ScopeValidator;
import com.portfolio.anubhab.portfolio.ai.PromptBuilder;
import com.portfolio.anubhab.portfolio.ai.OpenRouterClient;


@Service
public class AiService {

    private final OpenRouterClient client;
    private final PromptBuilder promptBuilder;
    private final ScopeValidator scopeValidator;
    private final ConversationMemory memory;
    private final ResponseParser parser;
    private final ResponseSanitizer sanitizer;

    public AiService(
            OpenRouterClient client,
            PromptBuilder promptBuilder,
            ScopeValidator scopeValidator,
            ConversationMemory memory,
            ResponseParser parser,
            ResponseSanitizer sanitizer
    ) {
        this.client = client;
        this.promptBuilder = promptBuilder;
        this.scopeValidator = scopeValidator;
        this.memory = memory;
        this.parser = parser;
        this.sanitizer = sanitizer;
    }

    public String getAnswer(String question) {

        if (!scopeValidator.isInScope(question)) {
            return scopeValidator.outOfScopeMessage();
        }

        String prompt = promptBuilder.buildPrompt(question);

        memory.add("User: " + question);

        String raw = client.ask(prompt);

        String parsed = parser.parse(raw);
        String clean = sanitizer.sanitize(parsed);

        memory.add("AI: " + clean);

        return clean;
    }
}
