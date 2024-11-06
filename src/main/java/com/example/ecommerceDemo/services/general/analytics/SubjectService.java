package com.example.ecommerceDemo.services.general.analytics;

import com.example.ecommerceDemo.DTO.general.analytics.SubjectDTO;
import com.example.ecommerceDemo.entities.general.analytics.SubjectEntity;
import com.example.ecommerceDemo.repositories.general.analytics.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;

    }

    public List<SubjectDTO> getSubjectsByUserId(Long userId) {
        List<SubjectEntity> subjectEntities = subjectRepository.findByUserUserId(userId);
        List<SubjectDTO> subjectDTOs = new ArrayList<>();
        for (SubjectEntity subjectEntity : subjectEntities) {
            SubjectDTO subjectDTO = new SubjectDTO(
                    subjectEntity.getSubjectId(),
                    subjectEntity.getSubjectName(),
                    subjectEntity.getSeries()
            );
            subjectDTOs.add(subjectDTO);
        }

        return subjectDTOs;
    }
}



