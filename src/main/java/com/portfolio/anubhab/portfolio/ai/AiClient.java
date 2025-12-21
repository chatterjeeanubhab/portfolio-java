package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class AiClient {

    private final PromptBuilder promptBuilder;
    private final OpenRouterClient openRouterClient;
    private final QuestionValidator questionValidator;

    public AiClient(PromptBuilder promptBuilder,
                    OpenRouterClient openRouterClient,
                    QuestionValidator questionValidator) {
        this.promptBuilder = promptBuilder;
        this.openRouterClient = openRouterClient;
        this.questionValidator = questionValidator;
    }

    public String ask(String userQuestion) {

        // 🚫 HARD BLOCK (NO AI CALL)
        if (!questionValidator.isAllowed(userQuestion)) {
            return """
            I can only answer questions related to Anubhab Chattopadhyay’s
            professional background, skills, projects, and hiring profile.
            """;
        }

        // ✅ Build controlled prompt
        String prompt = promptBuilder.buildPrompt(userQuestion);

        // ✅ Call AI
        String rawResponse = openRouterClient.ask(prompt);

        // ✅ Final response cleanup
        return sanitizeResponse(rawResponse);
    }

    private String sanitizeResponse(String response) {
        if (response == null || response.isBlank()) {
            return "I’m unable to generate a response right now. Please try again.";
        }

        // Optional: trim very long answers
        if (response.length() > 800) {
            return response.substring(0, 800) + "...";
        }

        return response.trim();
    }
}
