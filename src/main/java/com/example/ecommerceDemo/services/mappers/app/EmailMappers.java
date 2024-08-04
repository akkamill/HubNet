package com.example.ecommerceDemo.services.mappers.app;

import com.example.ecommerceDemo.DTO.app.EmailDTO;
import com.example.ecommerceDemo.entities.app.EmailEntity;
import org.springframework.stereotype.Component;

@Component
public class EmailMappers {

    public static EmailEntity toEntity(EmailDTO emailDTO) {

        EmailEntity emailEntity = new EmailEntity();

        emailEntity.setEmailId(emailDTO.getEmailId());
        emailEntity.setSubject(emailDTO.getSubject());
        emailEntity.setBody(emailDTO.getBody());
        emailEntity.setAttachment(emailDTO.getAttachment());
        emailEntity.setEmailStatus(emailDTO.getEmailStatus());
        emailEntity.setDraft(emailDTO.isDraft());
        emailEntity.setImportant(emailDTO.isImportant());
        emailEntity.setRead(emailDTO.isRead());

//        emailEntity.setSenderEmail(UserMappers.toEntity(emailDTO.getSenderEmail()));

        return emailEntity;
    }

    public static EmailDTO toDTO(EmailEntity emailEntity) {

        EmailDTO emailDTO = new EmailDTO();

        emailDTO.setEmailId(emailEntity.getEmailId());
        emailDTO.setSubject(emailEntity.getSubject());
        emailDTO.setBody(emailEntity.getBody());
        emailDTO.setAttachment(emailEntity.getAttachment());
        emailDTO.setEmailStatus(emailEntity.getEmailStatus());
        emailDTO.setDraft(emailEntity.isImportant());
        emailDTO.setImportant(emailEntity.isImportant());
        emailDTO.setRead(emailEntity.isRead());

//        emailDTO.setSenderEmail(UserMappers.toDTO(emailEntity.getSenderEmail()));

        return emailDTO;
    }
}
