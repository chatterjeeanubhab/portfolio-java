package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

@Component
public class ResponseSanitizer {

    public String sanitize(String response) {
        if (response == null) return "";

        return response
                .replaceAll("(?i)i am an ai.*", "")
                .replaceAll("(?i)i'm nemotron.*", "")
                .trim();
    }
}
