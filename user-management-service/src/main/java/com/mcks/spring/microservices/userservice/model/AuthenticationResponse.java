package com.mcks.spring.microservices.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}

//eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYW5vai5zQGVtYWlsLmNvbSIsImV4cCI6MTU5NDE3MzA2MywiaWF0IjoxNTk0MTM3MDYzfQ.nk0bFe4HElbjKYCdSntMTV-3ThWdHrLsEisBcEZZxw8