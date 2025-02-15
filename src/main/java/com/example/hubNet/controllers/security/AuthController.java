package com.example.hubNet.controllers.security;

import com.example.hubNet.DTO.security.JwtResponse;
import com.example.hubNet.DTO.security.LoginRequest;
import com.example.hubNet.services.security.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        JwtResponse jwtResponse = authService.login(loginRequest);
        return ResponseEntity.ok(jwtResponse);
    }

    @GetMapping("/provider-login")
    public String login(@RequestParam(value = "error", required = false) String error) {
        return "login";
    }

    @GetMapping("/provider-login-success")
    public String loginSuccess(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return "redirect:/dashboard";
    }
}
