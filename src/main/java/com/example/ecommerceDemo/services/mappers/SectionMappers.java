package com.example.ecommerceDemo.services.mappers;

import com.example.ecommerceDemo.DTO.SectionDTO;
import com.example.ecommerceDemo.entities.app.SectionEntity;
import com.example.ecommerceDemo.entities.app.TaskEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SectionMappers {

    public static SectionDTO toDTO(SectionEntity sectionEntity) {
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setSectionId(sectionEntity.getSectionId());
        sectionDTO.setSectionName(sectionEntity.getSectionName());


        if (sectionEntity.getTasks() != null) {
            sectionDTO.setTasks(sectionEntity.getTasks().stream()
                    .map(TaskMappers::toDTO)
                    .collect(Collectors.toList()));
        } else {
            sectionDTO.setTasks(new ArrayList<>());
        }
        return sectionDTO;
    }

    public static SectionEntity toEntity(SectionDTO sectionDTO) {

        SectionEntity.Builder builder = new SectionEntity.Builder()
                .sectionId(sectionDTO.getSectionId())
                .sectionName(sectionDTO.getSectionName());

        List<TaskEntity> taskEntities = sectionDTO.getTasks() != null ?
                sectionDTO.getTasks().stream()
                        .map(taskDTO -> new TaskEntity.Builder().taskId(taskDTO.getTaskId()).build())
                        .collect(Collectors.toList()) :
                Collections.emptyList();

        builder.tasks(taskEntities);

        return builder.build();
    }
//        SectionEntity sectionEntity = new SectionEntity();
//        sectionEntity.setSectionId(sectionDTO.getSectionId());
//        sectionEntity.setSectionName(sectionDTO.getSectionName());
//
//        if (sectionDTO.getTasks() != null) {
//            sectionEntity.setTasks(sectionDTO.getTasks().stream()
//                    .map(TaskMappers::toEntity)
//                    .collect(Collectors.toList()));
//        } else {
//            sectionEntity.setTasks(new ArrayList<>());
//        }
//        return sectionEntit
}
