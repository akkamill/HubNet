package com.example.hubNet.services.mappers.general;

import com.example.hubNet.DTO.general.AuthorsDTO;
import com.example.hubNet.entities.general.users.AuthorsEntity;
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
