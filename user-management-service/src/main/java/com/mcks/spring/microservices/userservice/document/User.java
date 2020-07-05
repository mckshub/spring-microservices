package com.mcks.spring.microservices.userservice.document;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mcks.spring.microservices.userservice.proxy.category.Category;
import com.mcks.spring.microservices.userservice.proxy.role.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Document(collection = "User")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(Include.NON_NULL)
public class User implements Serializable {

	
    /**
	 * 
	 */
	private static final long serialVersionUID = 597875778256233516L;

	@Id
	@Indexed(unique = true)
    private String userName;

    private String firstName;

    private String lastName;

    private String gender;

    private String contactNumber;
    
    private String address;

    private String mapLocation;

    private List<Category> categories;

    private Role role;

}
