package com.mcks.spring.microservices.userservice.controller;

import java.util.List;

import com.mcks.spring.microservices.userservice.model.AuthenticationRequest;
import com.mcks.spring.microservices.userservice.model.AuthenticationResponse;
import com.mcks.spring.microservices.userservice.util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
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

	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

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

	@PostMapping(value = "/authenticateUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public UserResponseVO autheticateUser(@RequestBody UserRequestVO requestVO) {
		UserResponseVO responseVO = new UserResponseVO();
		try {
			userService.authenticateUser(requestVO.getUser().getUsername());
			responseVO.setStatus(true);
			responseVO.setStatusMessage("User authentication successful !");
		} catch (Exception e) {
			LOGGER.error(e.getMessage());
			responseVO.setStatus(false);
			responseVO.setStatusMessage(e.getMessage());
		}
		return responseVO;
	}

	@PostMapping(value = "/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try{
		 authenticationManager.authenticate(
		 		new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch(BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}

		final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		LOGGER.info ("UserServiceController.class ==> JWT Token generated : {}", jwt);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
}
