package com.example.hubNet.services.home;

import com.example.hubNet.DTO.home.SupportDTO;
import com.example.hubNet.entities.home.SupportEntity;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.repositories.home.SupportRepository;
import com.example.hubNet.services.mappers.home.SupportMappers;
import org.springframework.stereotype.Service;

@Service
public class SupportService {

    private final SupportRepository supportRepository;
    private final UserRepository userRepository;

    public SupportService(SupportRepository supportRepository, UserRepository userRepository) {
        this.supportRepository = supportRepository;
        this.userRepository = userRepository;
    }

    public SupportDTO createMessage(SupportDTO supportDTO) {


        SupportEntity supportEntity = new SupportEntity();
        supportEntity.setName(supportDTO.getName());
        supportEntity.setEmail(supportDTO.getEmail());
        supportEntity.setSubject(supportDTO.getSubject());
        supportEntity.setMessage(supportDTO.getMessage());

        supportEntity = supportRepository.save(supportEntity);

        return SupportMappers.toDTO(supportEntity);


    }


}
