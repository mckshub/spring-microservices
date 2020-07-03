package com.mcks.spring.microservices.userservice.service;

import com.mcks.spring.microservices.userservice.document.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUser(final String email);

    User authenticateUser(final User user);

    boolean checkUserExists(String email);

    User addUser(final User user);

}
