package com.mcks.spring.microservices.userservice.document;

import com.mcks.spring.microservices.userservice.model.Role;
import com.mcks.spring.microservices.userservice.model.Category;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer userId;

    private String email;

    private String firstName;

    private String lastName;

    private String gender;

    private String countryCode;

    private String contactNumber;

    private Category category;

    private Role role;

    private Address address;

    private String mapLocation;

}
