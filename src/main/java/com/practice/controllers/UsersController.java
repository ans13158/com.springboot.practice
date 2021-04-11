package com.practice.controllers;

import com.practice.models.User;
import com.practice.repositories.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/users")
public class UsersController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/index")
    public List<User> index() {
        return userRepository.findAll();
    }

    @GetMapping(value="/user?name={name}")
    public User findByName(@RequestParam String name) {
        return userRepository.findByName(name);
    }

    @GetMapping(value="/{id}")
    public User show(@PathVariable final Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @PostMapping(value="/create")
    public User create(@RequestBody final User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    @PutMapping(value="/{id}")
    public User update(@RequestBody final Integer id, @RequestBody final User user) throws NotFoundException {
        User userRecord = userRepository.findById(id).get();
        if(userRecord==null)
            throw new NotFoundException("Couldn't find user with id " + id);
        else {
            userRepository.save(user);
        }
        return user;
    }
}
