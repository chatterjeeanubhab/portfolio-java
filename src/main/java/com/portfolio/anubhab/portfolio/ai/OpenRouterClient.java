package com.portfolio.anubhab.portfolio.ai;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.client.SimpleClientHttpRequestFactory;




@Component
public class OpenRouterClient {

    @Value("${openrouter.api.key}")
    private String apiKey;

    private static final String URL =
            "https://openrouter.ai/api/v1/chat/completions";

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

 public String ask(String prompt) {

    SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
factory.setConnectTimeout(5000);
factory.setReadTimeout(15000);

RestTemplate restTemplate = new RestTemplate(factory);


    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.setBearerAuth(apiKey);

    headers.add("HTTP-Referer", "http://localhost");
    headers.add("X-Title", "Portfolio AI Chatbot");

    String body = """
    {
      "model": "nvidia/nemotron-3-super-120b-a12b:free",
      "messages": [
        { "role": "system", "content": "You are a professional portfolio assistant." },
        { "role": "user", "content": "%s" }
      ]
    }
    """.formatted(prompt.replace("\"", "\\\""));

    HttpEntity<String> request = new HttpEntity<>(body, headers);

    ResponseEntity<String> response =
            restTemplate.postForEntity(URL, request, String.class);

    return extractText(response.getBody());
}
private String extractText(String json) {
    try {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        return root
                .path("choices")
                .get(0)
                .path("message")
                .path("content")
                .asText()
                .trim();
    } catch (Exception e) {
        return "Sorry, I couldn’t process the response at the moment.";
    }
}

}
