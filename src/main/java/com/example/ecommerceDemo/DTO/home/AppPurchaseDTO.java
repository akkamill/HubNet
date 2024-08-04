package com.example.ecommerceDemo.DTO.home;

import com.example.ecommerceDemo.DTO.user.UserDTO;
import com.example.ecommerceDemo.entities.home.enums.PurchaseType;
import lombok.Data;

@Data
public class AppPurchaseDTO {

    private Long purchaseId;
    private PurchaseType purchaseType;
    private boolean isYearly;
    private UserDTO userDTO;

}
