package com.example.ecommerceDemo.DTO;

import com.example.ecommerceDemo.entities.app.TaskEntity;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.scheduling.config.Task;

import java.util.List;

@Data
public class SectionDTO {


    private Long sectionId;
    private String sectionName;
    private List<TaskDTO> tasks;

}
