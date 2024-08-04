package com.example.ecommerceDemo.services.mappers.user;

import com.example.ecommerceDemo.DTO.user.SocialMediaLinksDTO;
import com.example.ecommerceDemo.entities.user.SocialMediaLinks;
import com.example.ecommerceDemo.services.mappers.user.page.UserDetailsMappers;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SocialMediaLinksMappers {


    public static SocialMediaLinks toEntity(SocialMediaLinksDTO socialMediaLinksDTO) {

        SocialMediaLinks socialMediaLinks = new SocialMediaLinks();

        socialMediaLinks.setSocialMediaId(socialMediaLinksDTO.getSocialMediaId());
        socialMediaLinks.setPlatform(socialMediaLinks.getPlatform());
        socialMediaLinks.setUrl(socialMediaLinks.getUrl());

        socialMediaLinks.setUserDetails(UserDetailsMappers.toEntity(socialMediaLinksDTO.getUserDetailsDTO()));

        return socialMediaLinks;
    }

    public static SocialMediaLinksDTO toDTO(SocialMediaLinks socialMediaLinks) {

        SocialMediaLinksDTO socialMediaLinksDTO = new SocialMediaLinksDTO();

        socialMediaLinksDTO.setSocialMediaId(socialMediaLinks.getSocialMediaId());
        socialMediaLinksDTO.setPlatform(socialMediaLinks.getPlatform());
        socialMediaLinksDTO.setUrl(socialMediaLinks.getUrl());

        return socialMediaLinksDTO;
    }

    public static List<SocialMediaLinks> toEntityList(List<SocialMediaLinksDTO> socialMediaDtoList) {
        if (socialMediaDtoList == null) {
            return Collections.emptyList();
        }
        return socialMediaDtoList.stream().map(SocialMediaLinksMappers::toEntity).collect(Collectors.toList());
    }

    public static List<SocialMediaLinksDTO> toDTOList(List<SocialMediaLinks> socialMediaLinks) {
        return socialMediaLinks.stream().map(SocialMediaLinksMappers::toDTO).collect(Collectors.toList());
    }


}
