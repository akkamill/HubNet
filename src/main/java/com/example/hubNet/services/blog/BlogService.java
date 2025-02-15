package com.example.hubNet.services.blog;

import com.example.hubNet.DTO.blog.BlogDTO;
import com.example.hubNet.entities.blog.BlogEntity;
import com.example.hubNet.entities.user.UserEntity;
import com.example.hubNet.repositories.blog.BlogRepository;
import com.example.hubNet.repositories.user.UserRepository;
import com.example.hubNet.services.mappers.blog.BlogMappers;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Service
public class BlogService {

    private final BlogRepository blogRepository;
    private final UserRepository userRepository;


    @Autowired
    public BlogService(BlogRepository blogRepository, UserRepository userRepository) {
        this.blogRepository = blogRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public BlogDTO createBlog(Long userId, BlogDTO blogDTO, MultipartFile blogImage) throws IOException {

        UserEntity user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        BlogEntity blogEntity = BlogMappers.toEntity(blogDTO);
        blogEntity.setUserEntity(user);

        if (blogImage != null && !blogImage.isEmpty()) {
            blogEntity.setBlogImage(blogImage.getBytes());

//            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\blogPhotos\\";
//
//            Path directory = Paths.get(uploadDir);
//            if (!Files.exists(directory)) {
//                Files.createDirectories(directory);
//            }
//
//            String filePath = uploadDir + blogEntity.getBlogId() + "_" + blogImage.getOriginalFilename();
//
//            Path blogPhotoPath = Paths.get(filePath);
//            Files.write(blogPhotoPath, blogImage.getBytes());
//
//            blogEntity.setBlogImagePath(filePath);
        }

        blogRepository.save(blogEntity);

        return BlogMappers.toDTO(blogEntity);
    }

    @Transactional
    public List<BlogDTO> getAllBlogs() {
        List<BlogEntity> entities = blogRepository.findAll();
        List<BlogDTO> dtoList = new ArrayList<>();
        for (BlogEntity b : entities) {
            BlogDTO blogDTO = BlogMappers.toDTO(b);

            dtoList.add(blogDTO);
        }
        return dtoList;
    }

    @Transactional
    public BlogDTO getBlogById(Long blogId) {

        BlogEntity blog = new BlogEntity();

        blogRepository.findById(blogId)
                .orElseThrow(() -> new EntityNotFoundException("Blog not found with id: " + blogId));

        return BlogMappers.toDTO(blog);
    }

    @Transactional
    public void deleteBlog(Long blogId) {
        blogRepository.deleteById(blogId);

    }

    @Transactional
    public void updateBlog(Long blogId, BlogDTO blogDTO) {

        BlogEntity blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setBlogTitle(blogDTO.getBlogTitle());
        blog.setBlogDescription(blogDTO.getBlogDescription());
        blog.setBlogContent(blogDTO.getBlogContent());
        blog.setBlogTags(blogDTO.getBlogTags());
//        blog.setBlogImage(blogDTO.getBlogImage());
        blog.setBlogMetaDescription(blogDTO.getBlogMetaDescription());
        blog.setBlogMetaKeywords(blogDTO.getBlogMetaKeywords());
        blog.setBlogMetaTitle(blogDTO.getBlogMetaTitle());

        blogRepository.save(blog);
        BlogMappers.toDTO(blog);
    }

    @Transactional
    public void isEnableComment(Long blogId, boolean isEnable) {

        BlogEntity blog = blogRepository.findById(blogId)
                .orElseThrow(() -> new RuntimeException("Blog not found"));

        blog.setEnableComment(isEnable);

        blogRepository.save(blog);
    }

    @Transactional
    public Page<BlogEntity> getLatestBlogs(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return blogRepository.findAllByOrderByCreatedAtDesc(pageRequest);
    }

    @Transactional
    public Page<BlogEntity> getNewestBlogs(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return blogRepository.findAllByOrderByCreatedAtAsc(pageRequest);
    }


    public String convertToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }

}