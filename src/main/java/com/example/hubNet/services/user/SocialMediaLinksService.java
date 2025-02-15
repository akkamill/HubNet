package com.example.hubNet.services.user;

import com.example.hubNet.DTO.user.SocialMediaLinksDTO;
import com.example.hubNet.entities.user.SocialMediaLinks;
import com.example.hubNet.entities.user.UserDetails;
import com.example.hubNet.repositories.user.SocialMediaLinksRepository;
import com.example.hubNet.repositories.user.UserDetailsRepository;
import com.example.hubNet.services.mappers.user.SocialMediaLinksMappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SocialMediaLinksService {

    private final SocialMediaLinksRepository socialMediaLinksRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public SocialMediaLinksService(SocialMediaLinksRepository socialMediaLinksRepository, UserDetailsRepository userDetailsRepository) {
        this.socialMediaLinksRepository = socialMediaLinksRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    public void createSocialMedia(Long userDetailsId, SocialMediaLinksDTO socialMediaLinksDTO) {

        UserDetails userDetails = userDetailsRepository.findById(userDetailsId)
                .orElseThrow(() -> new RuntimeException("User details not found " + userDetailsId));

        SocialMediaLinks socialMediaLinks = new SocialMediaLinks();

        socialMediaLinks.setPlatform(socialMediaLinksDTO.getPlatform());
        socialMediaLinks.setUrl(socialMediaLinksDTO.getUrl());
        socialMediaLinks.setUserDetails(userDetails);

        socialMediaLinksRepository.save(socialMediaLinks);

        SocialMediaLinksMappers.toDTO(socialMediaLinks);
    }
}
