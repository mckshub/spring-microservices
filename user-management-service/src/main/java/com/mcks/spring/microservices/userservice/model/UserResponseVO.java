package com.mcks.spring.microservices.userservice.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mcks.spring.microservices.userservice.document.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class UserResponseVO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
    private List<User> users;
    private boolean isUserAlreadyExists;
    private boolean status;
    private String statusMessage;

}
