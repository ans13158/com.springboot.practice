package com.practice.services;

import com.practice.models.User;
import com.practice.models.UserContacts;
import com.practice.repositories.UserContactRepository;
import com.practice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserContactService {
    @Autowired
    private UserContactRepository userContactRepository;
    @Autowired
    private UserRepository userRepository;

    public UserContacts createUserContacts(Integer userId, UserContacts userContact) {
        User contactable = userRepository.findById(userId).orElse(null);
        UserContacts contact = null;
        if(contactable==null) {
            throw new IllegalArgumentException("User does not exist");
        } else {
            contact = userContactRepository.save(userContact.setUsers(contactable));
        }

        return contact;
    }
}
