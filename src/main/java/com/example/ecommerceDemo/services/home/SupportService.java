package com.example.ecommerceDemo.services.home;

import com.example.ecommerceDemo.DTO.home.SupportDTO;
import com.example.ecommerceDemo.entities.home.SupportEntity;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.repositories.home.SupportRepository;
import com.example.ecommerceDemo.services.mappers.home.SupportMappers;
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
