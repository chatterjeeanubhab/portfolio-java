package com.portfolio.anubhab.portfolio.service;

import com.portfolio.anubhab.portfolio.model.ContactMessage;
import com.portfolio.anubhab.portfolio.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void saveMessage(ContactMessage message) {
        contactRepository.save(message);
        System.out.println("💾 Saved message to DB: " + message);
    }
}
