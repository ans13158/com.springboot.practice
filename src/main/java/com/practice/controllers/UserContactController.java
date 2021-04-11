package com.practice.controllers;

import com.practice.models.User;
import com.practice.models.UserContacts;
import com.practice.repositories.UserContactRepository;
import com.practice.services.UserContactService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user_contacts")
public class UserContactController {
    @Autowired
    private UserContactRepository userContactRepository;

    @Autowired
    private UserContactService userContactService;

    @GetMapping(value="/index")
    public List<UserContacts> index() {
        return userContactRepository.findAll();
    }

    @GetMapping(value="/{id}")
    public UserContacts getUserContact(@RequestParam final Integer id) {
        return (UserContacts) userContactRepository.findById(id).orElse(null);
    }

    @PostMapping(value="/create/{userId}")
    public UserContacts create(@PathVariable final Integer userId,
                               @RequestBody final UserContacts userContacts) {
        UserContacts contact = userContactService.createUserContacts(userId, userContacts);
        System.out.println(contact.toString());
        return contact;
    }
}
