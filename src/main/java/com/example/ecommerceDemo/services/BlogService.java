package com.example.ecommerceDemo.services;

import com.example.ecommerceDemo.DTO.BlogDTO;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.repositories.BlogRepository;
import com.example.ecommerceDemo.services.mappers.BlogMappers;
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
public class BlogService {

    private final BlogRepository blogRepository;
    private final BlogMappers blogMappers;


    @Autowired
    public BlogService(BlogRepository blogRepository, BlogMappers blogMappers) {
        this.blogRepository = blogRepository;
        this.blogMappers = blogMappers;
    }

    @Transactional
    public BlogDTO createBlog(BlogDTO blogDTO, MultipartFile blogImage) throws IOException {

        BlogEntity blogEntity = blogMappers.toEntity(blogDTO);

        if (blogImage != null && !blogImage.isEmpty()) {
            String uploadDir = "C:\\Users\\ASUS\\Desktop\\ecommersDemo\\src\\main\\resources\\blogPhotos\\";

            Path directory = Paths.get(uploadDir);
            if (!Files.exists(directory)) {
                Files.createDirectories(directory);
            }

            String filePath = uploadDir + blogEntity.getBlogId() + "_" + blogImage.getOriginalFilename();

            Path blogPhotoPath = Paths.get(filePath);
            Files.write(blogPhotoPath, blogImage.getBytes());

            blogEntity.setBlogImagePath(filePath);

        }

        blogRepository.save(blogEntity);

        return blogMappers.toDTO(blogEntity);
    }

    public List<BlogDTO> getAllBlogs() {
        List<BlogEntity> entities = blogRepository.findAll();
        List<BlogDTO> dtoList = new ArrayList<>();
        for (BlogEntity b : entities) {
            BlogDTO blogDTO = BlogMappers.toDTO(b);

            dtoList.add(blogDTO);
        }
        return dtoList;
    }


    //---------------------------------------------------------------------------------------------------------------//

//    public BlogEntity toEntity(BlogDTO blogDTO) {
//        BlogEntity blog = new BlogEntity();
//        blog.setBlogId(blogDTO.getBlogId());
//        blog.setBlogTitle(blogDTO.getBlogTitle());
//        blog.setBlogDescription(blogDTO.getBlogDescription());
//        blog.setBlogContent(blogDTO.getBlogContent());
//        blog.setBlogTags(blogDTO.getBlogTags());
//        blog.setBlogMetaTitle(blogDTO.getBlogMetaTitle());
//        blog.setBlogMetaDescription(blogDTO.getBlogMetaDescription());
//        blog.setBlogMetaKeywords(blogDTO.getBlogMetaKeywords());
//        blog.setNumberOfViews(blogDTO.getNumberOfViews());
//        blog.setBlogCreatedAt(blogDTO.getBlogCreatedAt());
//
//        if (blogDTO.getComments() != null) {
//            List<CommentEntity> commentEntities = blogDTO.getComments().stream()
//                    .map(commentDTO -> {
//                        CommentEntity commentEntity = new CommentEntity();
//                        commentEntity.setCommentName(commentDTO.getCommentName());
//                        commentEntity.setCommentText(commentDTO.getCommentText());
//                        commentEntity.setCommentEmail(commentDTO.getCommentEmail());
//                        return commentEntity;
//                    })
//                    .collect(Collectors.toList());
//            blog.setComments(commentEntities);
//        }
//
////        blog.setLikes(blogDTO.getLikes().stream()
////                .map(likeDTO -> likeService.toEntity(likeDTO))
////                .collect(Collectors.toList()));
//
//        return blog;
//
//    }
//
//    public BlogDTO toDTO(BlogEntity blog) {
//        BlogDTO blogDTO = new BlogDTO();
//        blogDTO.setBlogId(blog.getBlogId());
//        blogDTO.setBlogTitle(blog.getBlogTitle());
//        blogDTO.setBlogDescription(blog.getBlogDescription());
//        blogDTO.setBlogContent(blog.getBlogContent());
//        blogDTO.setBlogTags(blog.getBlogTags());
//        blogDTO.setBlogMetaTitle(blog.getBlogMetaTitle());
//        blogDTO.setBlogMetaDescription(blog.getBlogMetaDescription());
//        blogDTO.setBlogMetaKeywords(blog.getBlogMetaKeywords());
//        blogDTO.setNumberOfViews(blog.getNumberOfViews());
//        blogDTO.setBlogCreatedAt(blog.getBlogCreatedAt());
//
//        if (blog.getComments() != null) {
//            List<CommentDTO> commentDTOS = blog.getComments().stream()
//                    .map(commentEntity -> {
//                        CommentDTO commentDTO = new CommentDTO();
//                        commentDTO.setCommentName(commentEntity.getCommentName());
//                        commentDTO.setCommentText(commentEntity.getCommentText());
//                        commentDTO.setCommentEmail(commentEntity.getCommentEmail());
//                        return commentDTO;
//                    })
//                    .collect(Collectors.toList());
//            blogDTO.setComments(commentDTOS);
//        }
//
////        if (likeService != null && blog.getLikes() != null) {
////            blogDTO.setLikes(blog.getLikes().stream()
////                    .map(likeEntity -> likeService.toDTO(likeEntity))
////                    .collect(Collectors.toList()));
////        }
//        return blogDTO;
//    }
}
