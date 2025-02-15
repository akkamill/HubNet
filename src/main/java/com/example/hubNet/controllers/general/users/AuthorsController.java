package com.example.hubNet.controllers.general.users;

import com.example.hubNet.DTO.general.AuthorsDTO;
import com.example.hubNet.services.general.AuthorsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/authors")
public class AuthorsController {

    private final AuthorsService authorsService;

    public AuthorsController(AuthorsService authorsService) {
        this.authorsService = authorsService;
    }

    @GetMapping("/getAll")
    public List<AuthorsDTO> getAuthors() {
        return authorsService.getAuthors();
    }
}
