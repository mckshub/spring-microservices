package com.mcks.spring.microservices.userservice.service;

import java.util.List;
import java.util.Optional;

import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.model.UserRequestVO;
import com.mcks.spring.microservices.userservice.model.UserResponseVO;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUser(final String email);

    User authenticateUser(final User user);

    boolean checkUserExists(String email);

	UserResponseVO saveUser(final User user, String string, List<String> list);

	UserResponseVO modifyUser(UserRequestVO requestVO);

}
