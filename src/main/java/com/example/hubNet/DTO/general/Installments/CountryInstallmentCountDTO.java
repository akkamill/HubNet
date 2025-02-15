package com.example.hubNet.DTO.general.Installments;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CountryInstallmentCountDTO {

    private String country;
    private Long totalInstallments;

}