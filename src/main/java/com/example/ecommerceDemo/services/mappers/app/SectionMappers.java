package com.example.ecommerceDemo.services.mappers.app;

import com.example.ecommerceDemo.DTO.app.SectionDTO;
import com.example.ecommerceDemo.DTO.app.TaskDTO;
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

        SectionEntity sectionEntity = new SectionEntity();

        sectionEntity.setSectionId(sectionDTO.getSectionId());
        sectionEntity.setSectionName(sectionDTO.getSectionName());


//        if (sectionDTO.getTasks() != null) {
//            sectionEntity.setTasks(sectionDTO.getTasks().stream()
//                    .map(TaskMappers::toEntity)
//                    .collect(Collectors.toList()));
//        } else {
//            sectionEntity.setTasks(new ArrayList<>());
//        }
        return sectionEntity;
    }

    public static List<TaskEntity> toEntityList(List<TaskDTO> taskDTOList) {
        if (taskDTOList == null) {
            return Collections.emptyList();
        }
        return taskDTOList.stream().map(TaskMappers::toEntity).collect(Collectors.toList());
    }

    public static List<TaskDTO> toDTOList(List<TaskEntity> taskEntityList) {
        if (taskEntityList == null) {
            return Collections.emptyList();
        }
        return taskEntityList.stream().map(TaskMappers::toDTO).collect(Collectors.toList());
    }

}
