package com.example.hubNet.DTO.general.downloads;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class PlatformDownloads {
    private String platform;
    private BigDecimal totalDownloads;

}