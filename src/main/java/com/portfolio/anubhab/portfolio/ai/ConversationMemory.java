package com.portfolio.anubhab.portfolio.ai;

import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class ConversationMemory {

    private final List<String> history = new LinkedList<>();

    public void add(String entry) {
       history.add("[Conversation] " + entry);
        if (history.size() > 10) {
            history.remove(0);
        }
    }

   public String getConversationContext() {

    return history.isEmpty()

            ? "No previous conversation."

            : """
            Previous conversation:
            %s
            """.formatted(String.join("\n", history));
}
}
