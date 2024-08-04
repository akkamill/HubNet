package com.example.ecommerceDemo.services.app;

import com.example.ecommerceDemo.DTO.app.SectionDTO;
import com.example.ecommerceDemo.entities.app.SectionEntity;
import com.example.ecommerceDemo.repositories.app.SectionRepository;
import com.example.ecommerceDemo.services.mappers.app.SectionMappers;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService {

    private final SectionRepository sectionRepository;

    public SectionService(SectionRepository sectionRepository) {
        this.sectionRepository = sectionRepository;

    }

    public SectionDTO createSection(SectionDTO sectionDTO) {
        SectionEntity sectionEntity = SectionMappers.toEntity(sectionDTO);
        sectionEntity = sectionRepository.save(sectionEntity);
        return SectionMappers.toDTO(sectionEntity);
    }

    public List<SectionDTO> getAllSections() {
        List<SectionEntity> entities = sectionRepository.findAll();
        List<SectionDTO> dtoList = new ArrayList<>();
        for (SectionEntity s : entities) {
            SectionDTO sectionDTO = SectionMappers.toDTO(s);
            dtoList.add(sectionDTO);
        }
        return dtoList;
    }

    @Transactional
    public SectionDTO getSectionById(Long sectionId) {
        Optional<SectionEntity> sectionOptional = sectionRepository.findById(sectionId);
        if (sectionOptional.isPresent()) {
            return SectionMappers.toDTO(sectionOptional.get());
        } else {
            throw new RuntimeException("Section not found with ID: " + sectionId);
        }
    }

    public void deleteSection(Long sectionId) {
        sectionRepository.deleteById(sectionId);
    }


//-------------------------------------------------------------------------------------------------------------------//


}
