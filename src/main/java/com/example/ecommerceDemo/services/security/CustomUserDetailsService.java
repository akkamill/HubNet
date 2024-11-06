package com.example.ecommerceDemo.services.security;

import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByEmailAddress(email);

        UserEntity user = userOptional.orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        System.out.println("User found: " + user.getEmailAddress() + ", Password: " + user.getPassword());

        return new org.springframework.security.core.userdetails.User(user.getEmailAddress(), user.getPassword(), new ArrayList<>());
    }
}
