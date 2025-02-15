package com.example.hubNet.controllers.general.analytics;


import com.example.hubNet.entities.general.analytics.VisitsEntity;
import com.example.hubNet.services.general.analytics.VisitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/analytics")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping("/visits/country/{country}")
    public List<VisitsEntity> getVisitsByCountry(@PathVariable String country) {
        return visitService.getVisitsByCountry(country);
    }

    @GetMapping("/visits/comparison")
    public double getYearlyVisitComparison() {
        return visitService.getYearlyVisitComparison();
    }

}
