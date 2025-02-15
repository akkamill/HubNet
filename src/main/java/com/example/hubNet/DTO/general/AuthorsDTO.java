package com.example.hubNet.DTO.general;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AuthorsDTO {

    private Long authorId;
    private String authorName;
    private String authorSurname;
    private BigDecimal authorLikes;

}
