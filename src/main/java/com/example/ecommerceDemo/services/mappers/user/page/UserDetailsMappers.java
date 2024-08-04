package com.example.ecommerceDemo.services.mappers.user.page;

import com.example.ecommerceDemo.DTO.user.UserDetailsDTO;
import com.example.ecommerceDemo.entities.user.UserDetails;
import com.example.ecommerceDemo.services.mappers.user.SocialMediaLinksMappers;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMappers {

    public static UserDetails toEntity(UserDetailsDTO userDetailsDTO) {

        UserDetails userDetails = new UserDetails();

        userDetails.setPhoneNumber(userDetailsDTO.getPhoneNumber());
        userDetails.setCountry(userDetailsDTO.getCountry());
        userDetails.setCity(userDetailsDTO.getCity());
        userDetails.setState(userDetailsDTO.getState());
        userDetails.setZipCode(userDetailsDTO.getZipCode());
        userDetails.setCompany(userDetailsDTO.getCompany());
        userDetails.setAbout(userDetailsDTO.getAbout());
        userDetails.setProfilePhoto(userDetailsDTO.getProfilePhoto());
        userDetails.setProfilePhotoPath(userDetailsDTO.getProfilePhotoPath());
        userDetails.setEmailVerified(userDetailsDTO.isEmailVerified());
        userDetails.setProfilePublic(userDetailsDTO.isProfilePublic());

//        userDetails.setUser(UserMappers.toEntity(userDetailsDTO.getUserDTO()));

        userDetails.setSocialMediaLinks(SocialMediaLinksMappers.toEntityList(userDetailsDTO.getSocialMediaLinksDTOS()));

        return userDetails;

    }


        public static UserDetailsDTO toDTO(UserDetails userDetails) {

        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();

            userDetailsDTO.setPhoneNumber(userDetails.getPhoneNumber());
            userDetailsDTO.setCountry(userDetails.getCountry());
            userDetailsDTO.setCity(userDetails.getCity());
            userDetailsDTO.setState(userDetails.getState());
            userDetailsDTO.setZipCode(userDetails.getZipCode());
            userDetailsDTO.setCompany(userDetails.getCompany());
            userDetailsDTO.setAbout(userDetails.getAbout());
            userDetailsDTO.setProfilePhoto(userDetails.getProfilePhoto());
            userDetailsDTO.setProfilePhotoPath(userDetails.getProfilePhotoPath());
            userDetailsDTO.setEmailVerified(userDetails.isEmailVerified());
            userDetailsDTO.setProfilePublic(userDetails.isProfilePublic());

//            userDetailsDTO.setUserDTO(UserMappers.toDTO(userDetails.getUser()));

            userDetailsDTO.setSocialMediaLinksDTOS(SocialMediaLinksMappers.toDTOList(userDetails.getSocialMediaLinks()));

            return userDetailsDTO;

        }

}
