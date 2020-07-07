package com.mcks.spring.microservices.userservice.service;

import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.model.UserRequestVO;
import com.mcks.spring.microservices.userservice.model.UserResponseVO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsers();

    Optional<User> getUser(final String email);

    boolean checkUserExists(String email);

	UserResponseVO saveUser(final User user, String string, List<String> list);

	UserResponseVO modifyUser(UserRequestVO requestVO);

    User authenticateUser(String username) throws Exception;
}
