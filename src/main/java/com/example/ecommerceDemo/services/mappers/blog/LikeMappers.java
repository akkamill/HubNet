package com.example.ecommerceDemo.services.mappers.blog;

import com.example.ecommerceDemo.DTO.blog.LikeDTO;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import com.example.ecommerceDemo.services.mappers.user.UserMappers;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikeMappers {

    public static LikeEntity toEntity(LikeDTO likeDTO) {

        LikeEntity likeEntity = new LikeEntity();

        likeEntity.setLikeId(likeDTO.getLikeId());

        likeEntity.setBlog(BlogMappers.toEntity(likeDTO.getBlog()));

        likeEntity.setUser(UserMappers.toEntity(likeDTO.getUser()));

        return likeEntity;
    }

    public static LikeDTO toDTO(LikeEntity likeEntity) {

        LikeDTO likeDTO = new LikeDTO();

        likeDTO.setLikeId(likeEntity.getLikeId());
        likeDTO.setBlog(BlogMappers.toDTO(likeEntity.getBlog()));
        likeDTO.setUser(UserMappers.toDTO(likeEntity.getUser()));

        return likeDTO;
    }

    public static List<LikeEntity> toEntityList(List<LikeDTO> likeDTOList) {
        if (likeDTOList == null) {
            return Collections.emptyList();
        }
        return likeDTOList.stream().map(LikeMappers::toEntity).collect(Collectors.toList());
    }

    public static List<LikeDTO> toDTOList(List<LikeEntity> likeEntityList) {
        if (likeEntityList == null) {
            return Collections.emptyList();
        }
        return likeEntityList.stream().map(LikeMappers::toDTO).collect(Collectors.toList());
    }

}


//    public static LikeDTO toDTO(LikeEntity likeEntity) {
//        LikeDTO likeDTO = new LikeDTO();
//        likeDTO.setLikeId(likeEntity.getLikeId());
//
//        if (likeEntity.getBlog() != null) {
//            likeDTO.setBlog(BlogMappers.toDTO(likeEntity.getBlog()));
//        }
//
//        if (likeEntity.getUser() != null) {
//            likeDTO.setUser(UserMappers.toDTO(likeEntity.getUser()));
//        }
//
//        return likeDTO;
//    }
//
//    public LikeEntity toEntity(LikeDTO likeDTO) {
//        LikeEntity likeEntity = new LikeEntity();
//        likeEntity.setLikeId(likeDTO.getLikeId());
//
//        if (likeDTO.getBlog() != null) {
//            likeEntity.setBlog(BlogMappers.toEntity(likeDTO.getBlog()));
//        }
//
//        if (likeDTO.getUser() != null) {
//            likeEntity.setUser(UserMappers.toEntity(likeDTO.getUser()));
//        }
//
//        return likeEntity;
//    }
//
//
//}
