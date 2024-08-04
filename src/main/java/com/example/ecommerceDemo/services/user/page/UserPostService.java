package com.example.ecommerceDemo.services.user.page;

import com.example.ecommerceDemo.DTO.user.page.UserPostDTO;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.entities.user.page.UserPostEntity;
import com.example.ecommerceDemo.repositories.user.page.UserPostRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.services.mappers.user.page.UserPostMappers;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserPostService {

    private final UserPostRepository userPostRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserPostService(UserPostRepository userPostRepository, UserRepository userRepository) {
        this.userPostRepository = userPostRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserPostDTO createPost(Long userId, UserPostDTO userPostDTO, MultipartFile postImage) throws IOException {
        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        UserPostEntity userPost = UserPostMappers.toEntity(userPostDTO);
        userPost.setUser(user);

        if(postImage != null && !postImage.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\postPhotos\\";

            String filePath = uploadDir + userPost.getUserPostId() + "_" + postImage.getOriginalFilename();

            Path postPhotoPath = Paths.get(filePath);
            Files.write(postPhotoPath, postImage.getBytes());

            userPost.setPostImagePath(filePath);
        }
        userPostRepository.save(userPost);

        return UserPostMappers.toDTO(userPost);
    }

    @Transactional
    public UserPostDTO updateUserPost(Long userPostId, UserPostDTO userPostDTO) {
        UserPostEntity userPost = userPostRepository.findById(userPostId).orElseThrow(()
                -> new RuntimeException("User post not found"));

        userPost.setPostBody(userPostDTO.getPostBody());
        userPost.setPostImage(userPostDTO.getUserPostImage());

        userPostRepository.save(userPost);

        return UserPostMappers.toDTO(userPost);
    }

    @Transactional
    public void deletePost(Long userPostId) {
        userPostRepository.findById(userPostId);
    }

    @Transactional
    public List<UserPostDTO> getAllPosts() {
        List<UserPostEntity> entities = userPostRepository.findAll();
        List<UserPostDTO> dtoList = new ArrayList<>();
        for (UserPostEntity up : entities) {
            UserPostDTO userPostDTO = UserPostMappers.toDTO(up);

            dtoList.add(userPostDTO);
        }
        return dtoList;
    }

    @Transactional
    public UserPostDTO getPost(Long userPostId) {
        UserPostEntity userPost = new UserPostEntity();

        userPostRepository.findById(userPostId).orElseThrow(()
                -> new RuntimeException("User post not found"));

        return UserPostMappers.toDTO(userPost);
    }
}
