package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class ResponseParser {

    /**
     * Extracts assistant text from OpenRouter raw JSON.
     * For now, keep it simple and return raw response.
     */
    public String parse(String rawResponse) {
        if (rawResponse == null) {
            return "No response from AI.";
        }

        // TEMP: return raw text
        return rawResponse;
    }
}
