package com.example.ecommerceDemo.DTO.others;

import lombok.Data;

@Data
public class LoginRequest {

    private String emailAddress;
    private String password;
}