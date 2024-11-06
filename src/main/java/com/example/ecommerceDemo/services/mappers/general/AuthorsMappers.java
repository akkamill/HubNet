package com.example.ecommerceDemo.services.mappers.general;

import com.example.ecommerceDemo.DTO.general.AuthorsDTO;
import com.example.ecommerceDemo.entities.general.AuthorsEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorsMappers {

 

    public AuthorsEntity dtoToEntity(AuthorsDTO authorsDTO) {
        if (authorsDTO == null) {
            return null;
        }

        AuthorsEntity author = new AuthorsEntity();

        author.setAuthorId(authorsDTO.getAuthorId());
        author.setAuthorName(authorsDTO.getAuthorName());
        author.setAuthorSurname(authorsDTO.getAuthorSurname());
        author.setAuthorLikes(authorsDTO.getAuthorLikes());

        return author;
    }
}
