package com.example.ecommerceDemo.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class ShippingAddressDTO {


    private Long shippingId;
    private String shippingName;
    private String shippingLastName;
    private String shippingEmail;
    protected boolean emailNews;
    private String shippingAddress;
    private String shippingDoorNo;
    private String shippingCountry;
    private String shippingCity;
    private String shippingState;
    private String shippingZipCode;
    private String shippingMobNumber;
    private boolean textNews;


}
