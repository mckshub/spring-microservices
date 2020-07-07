package com.mcks.spring.microservices.userservice.model;

import java.util.List;

import com.mcks.spring.microservices.userservice.document.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserRequestVO {

	private User user;
	
	private List<User> users;
	
	private List<String> usernames;
	
	private String roleCode;
	
	private List<String> categoryCodes;
	
}
