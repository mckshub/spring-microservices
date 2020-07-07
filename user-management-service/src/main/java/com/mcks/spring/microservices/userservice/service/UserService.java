package com.mcks.spring.microservices.userservice.service;

import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.model.UserRequestVO;
import com.mcks.spring.microservices.userservice.model.UserResponseVO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService extends UserDetailsService {

    List<User> getAllUsers();

    Optional<User> getUser(final String email);

    boolean checkUserExists(String email);

	UserResponseVO saveUser(final User user, String string, List<String> list);

	UserResponseVO modifyUser(UserRequestVO requestVO);

    User authenticateUser(String username) throws Exception;
}
