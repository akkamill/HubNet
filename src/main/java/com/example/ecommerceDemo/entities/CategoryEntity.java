package com.example.ecommerceDemo.entities;

import com.example.ecommerceDemo.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class CategoryEntity {//prudcts

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryName;

    @ManyToOne
    private CategoryEntity parentCategory;// null

    @OneToMany
    private List<CategoryEntity> childCategory;//shoes

    @OneToMany
    private List<ProductEntity> productEntity;//null

    private String categoryTitle;






}
