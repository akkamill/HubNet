package com.example.ecommerceDemo.DTO.user;

import lombok.Data;

@Data
public class SocialMediaLinksDTO {

    private Long socialMediaId;
    private String platform;
    private String url;

    private UserDetailsDTO userDetailsDTO;
}
