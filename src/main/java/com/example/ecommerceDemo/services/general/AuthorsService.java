package com.example.ecommerceDemo.services.general;

import com.example.ecommerceDemo.DTO.general.AuthorsDTO;
import com.example.ecommerceDemo.entities.general.AuthorsEntity;
import com.example.ecommerceDemo.repositories.general.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorsService {

    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsService(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    public List<AuthorsDTO> getAuthors() {

        List<AuthorsEntity> authorsEntities = authorsRepository.findAll();

        return authorsEntities.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }


    // -----------------------------------------------------------------------------------------------------------------//

    public AuthorsDTO toDTO(AuthorsEntity author) {
        if (author == null) {
            return null;
        }

        AuthorsDTO authorsDTO = new AuthorsDTO();

        authorsDTO.setAuthorId(author.getAuthorId());
        authorsDTO.setAuthorName(author.getAuthorName());
        authorsDTO.setAuthorSurname(author.getAuthorSurname());
        authorsDTO.setAuthorLikes(author.getAuthorLikes());

        return authorsDTO;
    }
}
