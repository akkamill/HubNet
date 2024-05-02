package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.LikeDTO;
import com.example.ecommerceDemo.entities.UserEntity;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import com.example.ecommerceDemo.repositories.BlogRepository;
import com.example.ecommerceDemo.repositories.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final BlogRepository blogRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository,
                       BlogRepository blogRepository) {
        this.likeRepository = likeRepository;
        this.blogRepository = blogRepository;
    }

    public void createLike(Long userId, Long blogId) {
        LikeEntity likeEntity = new LikeEntity();

        UserEntity user = new UserEntity();
        user.setUserId(userId);
        likeEntity.setUser(user);

        BlogEntity blog = blogRepository.findById(blogId).orElseThrow(()
                -> new RuntimeException("Blog not found"));
        likeEntity.setBlog(blog);

        likeRepository.save(likeEntity);
    }

    //---------------------------------------------------------------------------------------------------------------//


//    @Override
//    public LikeDTO toDTO(LikeEntity likeEntity) {
//        LikeDTO likeDTO = new LikeDTO();
//        likeDTO.setLikeId(likeEntity.getLikeId());
//
//        if (likeEntity.getBlog() != null) {
//            likeDTO.setBlog(blogService.toDTO(likeEntity.getBlog()));
//        }
//
//        if (likeEntity.getUser() != null) {
//            likeDTO.setUser(userService.toDTO(likeEntity.getUser()));
//        }
//
//        return likeDTO;
//    }
//
//    @Override
//    public LikeEntity toEntity(LikeDTO likeDTO) {
//        LikeEntity likeEntity = new LikeEntity();
//        likeEntity.setLikeId(likeDTO.getLikeId());
//
//        if (likeDTO.getBlog() != null) {
//            likeEntity.setBlog(blogService.toEntity(likeDTO.getBlog()));
//        }
//
//        if (likeDTO.getUser() != null) {
//            likeEntity.setUser(userService.toEntity(likeDTO.getUser()));
//        }
//
//        return likeEntity;
//    }
}
