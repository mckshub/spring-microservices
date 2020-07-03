package com.mcks.spring.microservices.userservice.service.impl;

import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.repository.UserRepository;
import com.mcks.spring.microservices.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User authenticateUser(User user) {
        return null;
    }

    @Override
    public boolean checkUserExists(String email) {
        return email.equalsIgnoreCase(getUser(email).getEmail());
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

}
