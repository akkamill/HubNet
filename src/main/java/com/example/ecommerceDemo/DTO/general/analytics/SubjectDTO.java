package com.example.ecommerceDemo.DTO.general.analytics;

import lombok.Data;


@Data
public class SubjectDTO {

    private Long subjectId;
    private String subjectName;
    private String series;
    private Long userId;

    public SubjectDTO(Long subjectId, String subjectName, String series) {
    }
}
