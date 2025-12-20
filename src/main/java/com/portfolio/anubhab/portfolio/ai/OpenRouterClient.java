package com.portfolio.anubhab.portfolio.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class OpenRouterClient {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private static final String URL =
            "https://openrouter.ai/api/v1/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public String ask(String question) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setBearerAuth(apiKey);

            // Required by OpenRouter
            headers.add("HTTP-Referer", "http://localhost");
            headers.add("X-Title", "Portfolio AI Chatbot");

            String body = """
            {
              "model": "nvidia/nemotron-nano-12b-v2-vl:free",
              "messages": [
                {
                  "role": "system",
                  "content": "You are an AI assistant for Anubhab Chattopadhyay's portfolio website. Answer professionally and concisely."
                },
                {
                  "role": "user",
                  "content": "%s"
                }
              ]
            }
            """.formatted(question.replace("\"", "\\\""));

            HttpEntity<String> request = new HttpEntity<>(body, headers);
            ResponseEntity<String> response =
                    restTemplate.postForEntity(URL, request, String.class);

            JsonNode root = objectMapper.readTree(response.getBody());
            return root
                    .path("choices")
                    .get(0)
                    .path("message")
                    .path("content")
                    .asText();

        } catch (Exception e) {
            return "AI service is temporarily unavailable. Please try again.";
        }
    }
}
