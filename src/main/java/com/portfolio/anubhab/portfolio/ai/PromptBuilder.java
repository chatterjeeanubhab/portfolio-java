package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class PromptBuilder {

    private final ConversationMemory memory;
    private final ProfileContext profileContext;

    public PromptBuilder(ConversationMemory memory, ProfileContext profileContext) {
        this.memory = memory;
        this.profileContext = profileContext;
    }

    public String buildPrompt(String userQuestion) {

        return """
        You are an AI assistant for a professional portfolio website.

        You MUST follow these rules:
        - Use ONLY the information provided below
        - Do NOT guess, invent, or generalize
        - Answer professionally and concisely
        - If the question is unrelated to the portfolio, politely redirect the visitor toward portfolio-related topics

        ======================
        %s
        ======================

        Conversation context:
        %s

        Visitor question:
        "%s"
        """.formatted(
                profileContext.getProfile(),
                memory.getConversationContext(),
                userQuestion
        );
    }
}
