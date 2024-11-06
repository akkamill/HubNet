package com.example.ecommerceDemo.DTO.general.Installments;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryInstallmentCountDTO {

    private String country;
    private Long totalInstallments;

}