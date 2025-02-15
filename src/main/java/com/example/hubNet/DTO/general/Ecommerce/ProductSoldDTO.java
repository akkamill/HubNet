package com.example.hubNet.DTO.general.Ecommerce;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductSoldDTO {

    private Long productSoldId;
    private int productSoldQuantity;
    private String saleByGender;
    private LocalDateTime saleDate;


}
