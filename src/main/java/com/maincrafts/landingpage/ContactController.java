package com.maincrafts.landingpage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    private ContactRepository repo;

    @PostMapping("/contact")
    public String handleContact(@RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String message) {
        
        Contact newContact = new Contact();
        newContact.setName(name);
        newContact.setEmail(email);
        newContact.setMessage(message);
        
        repo.save(newContact);
        
        return "Form submitted and saved to database successfully!";
    }

    @GetMapping("/contacts")
    public List<Contact> getAllContacts() {
        return repo.findAll();
    }
}
