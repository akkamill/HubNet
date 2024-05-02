package com.example.ecommerceDemo.services.mappers;

import com.example.ecommerceDemo.DTO.LikeDTO;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import org.springframework.stereotype.Component;

@Component
public class LikeMappers {


    public static LikeDTO toDTO(LikeEntity likeEntity) {
        LikeDTO likeDTO = new LikeDTO();
        likeDTO.setLikeId(likeEntity.getLikeId());

        if (likeEntity.getBlog() != null) {
            likeDTO.setBlog(BlogMappers.toDTO(likeEntity.getBlog()));
        }

        if (likeEntity.getUser() != null) {
            likeDTO.setUser(UserMappers.toDTO(likeEntity.getUser()));
        }

        return likeDTO;
    }

    public LikeEntity toEntity(LikeDTO likeDTO) {
        LikeEntity likeEntity = new LikeEntity();
        likeEntity.setLikeId(likeDTO.getLikeId());

        if (likeDTO.getBlog() != null) {
            likeEntity.setBlog(BlogMappers.toEntity(likeDTO.getBlog()));
        }

        if (likeDTO.getUser() != null) {
            likeEntity.setUser(UserMappers.toEntity(likeDTO.getUser()));
        }

        return likeEntity;
    }


}
