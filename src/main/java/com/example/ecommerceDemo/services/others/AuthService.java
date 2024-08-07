package com.example.ecommerceDemo.services.others;

import com.example.ecommerceDemo.DTO.others.JwtResponse;
import com.example.ecommerceDemo.DTO.others.LoginRequest;
import com.example.ecommerceDemo.config.security.JwtUtil;
import com.example.ecommerceDemo.services.user.CustomUserDetailsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Transactional
    public JwtResponse login(LoginRequest loginRequest) {
        System.out.println("Attempting to authenticate user: " + loginRequest.getEmailAddress());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmailAddress(), loginRequest.getPassword())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        System.out.println("User authenticated: " + userDetails.getUsername());
        String jwt = jwtUtil.generateToken(userDetails);
        System.out.println("Generated JWT: " + jwt);

        return new JwtResponse(jwt);
    }

}
