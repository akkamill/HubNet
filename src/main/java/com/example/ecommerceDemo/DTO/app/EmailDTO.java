package com.example.ecommerceDemo.DTO.app;

import com.example.ecommerceDemo.entities.app.enums.EmailStatus;
import jakarta.persistence.Transient;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class EmailDTO {

    private Long emailId;
    private String senderEmail;
    private List<String> recipientEmailAddresses;
    private String subject;
    private String body;
    private EmailStatus emailStatus;
    private boolean isDraft;
    private boolean isImportant;
    private boolean isRead;

    @Transient
    private MultipartFile attachment;
    private String attachmentPath;

}
