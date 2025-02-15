package com.example.hubNet.DTO.security;

import lombok.Data;

@Data
public class LoginRequest {

    private String emailAddress;
    private String password;
}
