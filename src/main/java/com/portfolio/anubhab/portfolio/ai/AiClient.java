package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class AiClient {

    public String ask(String prompt) {

        // Mock response (FREE, no external API)
        return """
        [AI MOCK RESPONSE]

        Based on Anubhab's profile:

        """ + prompt;
    }
}
