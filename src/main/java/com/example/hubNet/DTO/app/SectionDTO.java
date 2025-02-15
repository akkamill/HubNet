package com.example.hubNet.DTO.app;

import lombok.Data;

import java.util.List;

@Data
public class SectionDTO {


    private Long sectionId;
    private String sectionName;
    private List<TaskDTO> tasks;

}
