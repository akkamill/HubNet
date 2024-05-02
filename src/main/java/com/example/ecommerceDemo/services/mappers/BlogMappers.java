package com.example.ecommerceDemo.services.mappers;

import com.example.ecommerceDemo.DTO.BlogDTO;
import com.example.ecommerceDemo.DTO.CommentDTO;
import com.example.ecommerceDemo.entities.blog.BlogEntity;
import com.example.ecommerceDemo.entities.blog.CommentEntity;
import com.example.ecommerceDemo.entities.blog.LikeEntity;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class BlogMappers {



    public static BlogEntity toEntity(BlogDTO blogDTO) {

        BlogEntity.Builder builder = new BlogEntity.Builder()
                .blogId(blogDTO.getBlogId())
                .blogTitle(blogDTO.getBlogTitle())
                .blogDescription(blogDTO.getBlogMetaDescription())
                .blogContent(blogDTO.getBlogContent())
                .blogTags(blogDTO.getBlogTags())
                .blogMetaTitle(blogDTO.getBlogMetaTitle())
                .blogMetaKeywords(blogDTO.getBlogMetaKeywords())
                .numberOfViews(blogDTO.getNumberOfViews())
                .blogCreatedAt(blogDTO.getBlogCreatedAt())
                .likes(blogDTO.getLikes().stream()
                        .map(likeDTO -> new LikeEntity.Builder().likeId(likeDTO.getLikeId()).build())
                        .collect(Collectors.toList()));

        if (blogDTO.getComments() != null) {
            List<CommentEntity> commentEntities = blogDTO.getComments().stream()
                    .map(commentDTO -> {
                        CommentEntity commentEntity = new CommentEntity();
                        commentEntity.setCommentName(commentDTO.getCommentName());
                        commentEntity.setCommentText(commentDTO.getCommentText());
                        commentEntity.setCommentEmail(commentDTO.getCommentEmail());
                        return commentEntity;
                    })
                    .collect(Collectors.toList());
            builder.comments(commentEntities);
        }
        return builder.build();
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
//                blog.setBlogId(blogDTO.getBlogId());
//        blog.setBlogTitle(blogDTO.getBlogTitle());
//        blog.setBlogDescription(blogDTO.getBlogDescription());
//        blog.setBlogContent(blogDTO.getBlogContent());
//        blog.setBlogTags(blogDTO.getBlogTags());
//        blog.setBlogMetaTitle(blogDTO.getBlogMetaTitle());
//        blog.setBlogMetaDescription(blogDTO.getBlogMetaDescription());
//        blog.setBlogMetaKeywords(blogDTO.getBlogMetaKeywords());
//        blog.setBlogCreatedAt(blogDTO.getBlogCreatedAt());
//        blog.setNumberOfViews(blogDTO.getNumberOfViews());
    }


    public static BlogDTO toDTO(BlogEntity blog) {
        BlogDTO blogDTO = new BlogDTO();
        blogDTO.setBlogId(blog.getBlogId());
        blogDTO.setBlogTitle(blog.getBlogTitle());
        blogDTO.setBlogDescription(blog.getBlogDescription());
        blogDTO.setBlogContent(blog.getBlogContent());
        blogDTO.setBlogTags(blog.getBlogTags());
        blogDTO.setBlogMetaTitle(blog.getBlogMetaTitle());
        blogDTO.setBlogMetaDescription(blog.getBlogMetaDescription());
        blogDTO.setBlogMetaKeywords(blog.getBlogMetaKeywords());
        blogDTO.setNumberOfViews(blog.getNumberOfViews());
        blogDTO.setBlogCreatedAt(blog.getBlogCreatedAt());


        if (blog.getComments() != null) {
            List<CommentDTO> commentDTOS = blog.getComments().stream()
                    .map(commentEntity -> {
                        CommentDTO commentDTO = new CommentDTO();
                        commentDTO.setCommentName(commentEntity.getCommentName());
                        commentDTO.setCommentText(commentEntity.getCommentText());
                        commentDTO.setCommentEmail(commentEntity.getCommentEmail());
                        return commentDTO;
                    })
                    .collect(Collectors.toList());
            blogDTO.setComments(commentDTOS);
        }

        if (blog.getLikes() != null) {
            blogDTO.setLikes(blog.getLikes().stream()
                    .map(likeEntity -> LikeMappers.toDTO(likeEntity))
                    .collect(Collectors.toList()));
        }
        return blogDTO;
    }

}
