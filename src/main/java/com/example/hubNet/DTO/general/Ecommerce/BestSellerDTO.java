package com.example.hubNet.DTO.general.Ecommerce;

import com.example.hubNet.enums.SellerStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class BestSellerDTO {

        private Long bestSellerId;
        private String sellerName;
        private String sellerSurname;
        private String sellerEmailAddress;
        private String sellerCountry;
        private BigDecimal totalAmount;
        private SellerStatus sellerStatus;

}
