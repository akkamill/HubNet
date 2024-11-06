package com.example.ecommerceDemo.DTO.general.downloads;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DownloadsDTO {

    private Long downloadId;
    private String platforms;
    private BigDecimal totalDownloads;


}
