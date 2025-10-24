package com.portfolio.anubhab.portfolio.controller;

import com.portfolio.anubhab.portfolio.model.ContactMessage;
import com.portfolio.anubhab.portfolio.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping("/contact")
    public String contactPage() {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContact(@ModelAttribute ContactMessage message, Model model) {
        System.out.println("✅ Received message from " + message.getName());
        System.out.println("Full Details: " + message);
        contactService.saveMessage(message);
        model.addAttribute("success", "Your message has been sent!");
        return "contact";
    }

}
