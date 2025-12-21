package com.portfolio.anubhab.portfolio.controller;

import com.portfolio.anubhab.portfolio.service.AiService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
@RestController
@RequestMapping("/api/ai")
public class AiController {

    private final AiService aiService;

    public AiController(AiService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/ask")
    public Map<String, String> askAi(@RequestBody Map<String, String> body) {
        String question = body.get("question");
        String answer = aiService.getAnswer(question);
        return Map.of("answer", answer);
    }
}
