package com.example.ecommerceDemo.DTO.general.analytics;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class ConversionDTO {

    private Long conversionId;
    private int conversionRates;
    private LocalDateTime conversionDate;
    private Long userId;

}
