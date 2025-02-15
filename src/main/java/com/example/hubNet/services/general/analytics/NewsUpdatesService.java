package com.example.hubNet.services.general.analytics;

import com.example.hubNet.DTO.general.analytics.NewsUpdatesDTO;
import com.example.hubNet.entities.general.analytics.NewsUpdatesEntity;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.repositories.general.analytics.NewsUpdatesRepository;
import com.example.hubNet.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsUpdatesService {

    private final NewsUpdatesRepository newsUpdatesRepository;
    private final UserRepository userRepository;

    @Autowired
    public NewsUpdatesService(NewsUpdatesRepository newsUpdatesRepository,
                              UserRepository userRepository) {
        this.newsUpdatesRepository = newsUpdatesRepository;
        this.userRepository = userRepository;
    }

    private UserEntity getUserById(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public List<NewsUpdatesDTO> getNewsUpdatesByUserId(Long userId) {
        getUserById(userId);  // Ensure the user exists
        List<NewsUpdatesEntity> newsUpdates = newsUpdatesRepository.findByUserUserId(userId);
        List<NewsUpdatesDTO> newsUpdatesDTOs = new ArrayList<>();
        for (NewsUpdatesEntity entity : newsUpdates) {
            newsUpdatesDTOs.add(toDTO(entity));
        }
        return newsUpdatesDTOs;
    }




//    --------------------------------------------------------------------------------------------------------------//

    public NewsUpdatesDTO toDTO(NewsUpdatesEntity entity) {

        NewsUpdatesDTO dto = new NewsUpdatesDTO();

        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setSubtitle(entity.getSubtitle());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUserId(entity.getUser().getUserId());  // Assuming UserEntity has userId field

        return dto;
    }

    public NewsUpdatesEntity toEntity(NewsUpdatesDTO dto) {

        NewsUpdatesEntity entity = new NewsUpdatesEntity();

        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setSubtitle(dto.getSubtitle());
        entity.setCreatedAt(dto.getCreatedAt());

        return entity;
    }
}
