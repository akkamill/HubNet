package com.example.ecommerceDemo.DTO.eCommerce;

import lombok.Data;

@Data
public class ShippingAddressDTO {


    private Long shippingId;
    private String shippingName;
    private String shippingLastName;
    private String shippingEmail;
    private String shippingAddress;
    private String shippingDoorNo;
    private String shippingCountry;
    private String shippingCity;
    private String shippingState;
    private String shippingZipCode;
    private String shippingMobNumber;
    private boolean emailNews;
    private boolean textNews;


}
