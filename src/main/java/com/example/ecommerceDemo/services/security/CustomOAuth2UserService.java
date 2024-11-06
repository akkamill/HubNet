//package com.example.ecommerceDemo.services.security;
//
//import com.example.ecommerceDemo.entities.user.UserEntity;
//import com.example.ecommerceDemo.repositories.user.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
//import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
//import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
//import org.springframework.security.oauth2.core.user.OAuth2User;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.Map;
//
//@Service
//public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public CustomOAuth2UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public OAuth2User loadUser(OAuth2UserRequest userRequest) {
//
//        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
//        OAuth2User oAuth2User = delegate.loadUser(userRequest);
//
//        Map<String, Object> attributes = oAuth2User.getAttributes();
//
//        String email = (String) attributes.get("email");
//        String name = (String) attributes.get("name");
//        String lastName = (String) attributes.get("lastName");
//        String provider = userRequest.getClientRegistration().getRegistrationId();
//
//        UserEntity user = userRepository.findByEmailAddress(email)
//                .orElseGet(() -> {
//                    UserEntity newUser = new UserEntity();
//                    newUser.setEmailAddress(email);
//                    newUser.setName(name);
//                    newUser.setLastName(lastName);
//                    newUser.setProvider(provider);
//                    return userRepository.save(newUser);
//                });
//
//        return new DefaultOAuth2User(
//                Collections.singleton(new SimpleGrantedAuthority("USER")),
//                attributes,
//                "email"
//        );
//    }
//
//}
