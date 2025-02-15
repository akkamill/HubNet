package com.example.hubNet.DTO.home;

import com.example.hubNet.DTO.user.UserDTO;
import com.example.hubNet.entities.home.enums.PurchaseType;
import lombok.Data;

@Data
public class AppPurchaseDTO {

    private Long purchaseId;
    private PurchaseType purchaseType;
    private boolean isYearly;
    private UserDTO userDTO;

}
