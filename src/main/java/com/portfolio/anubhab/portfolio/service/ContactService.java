package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.model.ContactMessage;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactService {

    private List<ContactMessage> messages = new ArrayList<>();

    public void saveMessage(ContactMessage message) {
        messages.add(message); // simple in-memory storage
        System.out.println("Received message from " + message.getName());
    }

    public List<ContactMessage> getMessages() {
        return messages;
    }
}
