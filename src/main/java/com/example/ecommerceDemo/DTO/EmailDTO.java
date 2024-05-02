package com.example.ecommerceDemo.DTO;

import lombok.Data;

import java.util.List;

@Data
public class EmailDTO {

    private String senderEmail;
    private List<String> recipientEmail;
    private String subject;
    private String body;

}
