package com.mcks.spring.microservices.userservice.controller;

import java.util.List;

import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.model.UserResponseVO;
import com.mcks.spring.microservices.userservice.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/user")
public class UserServiceController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAllUsers.web")
    public UserResponseVO getAllUsers() {
        UserResponseVO responseVO = new UserResponseVO();
        List<User> allUsers = userService.getAllUsers();
        responseVO.setStatus(true);
        responseVO.setStatusMessage("Success");
        responseVO.setUsers(allUsers);
        return responseVO;
    }
}
