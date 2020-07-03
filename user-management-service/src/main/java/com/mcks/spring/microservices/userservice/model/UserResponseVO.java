package com.mcks.spring.microservices.userservice.model;

import com.mcks.spring.microservices.userservice.document.User;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseVO implements Serializable {

    private User user;
    private List<User> users;
    private boolean isUserAlreadyExists;
    private boolean status;
    private String statusMessage;

}
