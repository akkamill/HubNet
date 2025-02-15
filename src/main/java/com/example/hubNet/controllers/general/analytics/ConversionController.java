package com.example.hubNet.controllers.general.analytics;

import com.example.hubNet.DTO.general.analytics.ConversionDTO;
import com.example.hubNet.services.general.analytics.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/analytics")
public class ConversionController {

    private final ConversionService conversionService;

    public ConversionController(ConversionService conversionService) {
        this.conversionService = conversionService;
    }

    @GetMapping("get/{userId}")
    public List<ConversionDTO> getConversions(@PathVariable Long userId) {
        return conversionService.getConversionsByUserId(userId);  // Pass userId to the service method
    }
}
