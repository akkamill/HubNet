package com.example.ecommerceDemo.services.user.page;

import com.example.ecommerceDemo.DTO.user.page.UserCommentDTO;
import com.example.ecommerceDemo.entities.user.page.UserCommentEntity;
import com.example.ecommerceDemo.entities.user.UserEntity;
import com.example.ecommerceDemo.repositories.user.page.UserCommentRepository;
import com.example.ecommerceDemo.repositories.user.UserRepository;
import com.example.ecommerceDemo.services.mappers.user.UserCommentMappers;
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
public class UserCommentService {

    private final UserCommentRepository userCommentRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserCommentService(UserCommentRepository userCommentRepository, UserRepository userRepository) {
        this.userCommentRepository = userCommentRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserCommentDTO createComment(Long userId, UserCommentDTO userCommentDTO, MultipartFile commentImage) throws IOException {

        UserEntity user = userRepository.findById(userId).orElseThrow(()
                -> new RuntimeException("User not found"));

        UserCommentEntity userComment = UserCommentMappers.toEntity(userCommentDTO);
        userComment.setUser(user);

        if (commentImage != null && !commentImage.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\commentPhotos\\";

            String filePath = uploadDir + userComment.getUserCommentId() + "_" + commentImage.getOriginalFilename();

            Path commentPhotoPath = Paths.get(filePath);
            Files.write(commentPhotoPath, commentImage.getBytes());

            userComment.setCommentImagePath(filePath);
        }

        userCommentRepository.save(userComment);

        return UserCommentMappers.toDTO(userComment);
    }

    @Transactional
    public UserCommentDTO updateComment(Long userCommentId, UserCommentDTO userCommentDTO) {

        UserCommentEntity userComment = userCommentRepository.findById(userCommentId)
                .orElseThrow(() -> new RuntimeException("User comment not found"));

        userComment.setCommentText(userCommentDTO.getCommentText());
        userComment.setCommentImage(userCommentDTO.getCommentImage());

        userCommentRepository.save(userComment);

        return UserCommentMappers.toDTO(userComment);
    }

    @Transactional
    public List<UserCommentDTO> getAllComments() {

        List<UserCommentEntity> entities = userCommentRepository.findAll();
        List<UserCommentDTO> dtoList = new ArrayList<>();
        for (UserCommentEntity uc : entities) {
            UserCommentDTO userCommentDTO = UserCommentMappers.toDTO(uc);

            dtoList.add(userCommentDTO);
        }
        return dtoList;
    }

    @Transactional
    public void deleteComment(Long userCommentId) {
        userCommentRepository.deleteById(userCommentId);
    }
}
