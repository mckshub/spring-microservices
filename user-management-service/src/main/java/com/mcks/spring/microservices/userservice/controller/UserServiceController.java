package com.mcks.spring.microservices.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mcks.spring.microservices.userservice.document.User;
import com.mcks.spring.microservices.userservice.model.UserRequestVO;
import com.mcks.spring.microservices.userservice.model.UserResponseVO;
import com.mcks.spring.microservices.userservice.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserServiceController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/getAllUsers", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponseVO getAllUsers() {
		UserResponseVO responseVO = new UserResponseVO();
		List<User> allUsers = userService.getAllUsers();
		responseVO.setStatus(true);
		responseVO.setStatusMessage("Success");
		responseVO.setUsers(allUsers);
		return responseVO;
	}

	@PostMapping(value = "/saveUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponseVO saveUser(@RequestBody UserRequestVO requestVO) {
		return userService.saveUser(requestVO.getUser(), requestVO.getRoleCode(), requestVO.getCategoryCodes());
	}
	
	@PostMapping(value = "/modifyUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponseVO modifyUser(@RequestBody UserRequestVO requestVO) {
		return userService.modifyUser(requestVO);
	}
}
