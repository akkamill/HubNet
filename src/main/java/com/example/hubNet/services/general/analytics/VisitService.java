package com.example.hubNet.services.general.analytics;

import com.example.hubNet.DTO.general.analytics.VisitsDTO;
import com.example.hubNet.entities.general.analytics.VisitsEntity;
import com.example.hubNet.repositories.general.analytics.VisitsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    private final VisitsRepository visitsRepository;

    public VisitService(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }


    public List<VisitsEntity> getVisitsByCountry(String country) {
        return visitsRepository.findByVisitCountry(country);
    }

    public Long getTotalVisitsForCurrentYear() {
        return visitsRepository.getTotalVisitsForCurrentYear();
    }

    public Long getTotalVisitsForLastYear() {
        return visitsRepository.getTotalVisitsForLastYear();
    }


    public double getYearlyVisitComparison() {
        Long currentYearVisits = getTotalVisitsForCurrentYear();
        Long lastYearVisits = getTotalVisitsForLastYear();

        if (lastYearVisits == 0) {
            return currentYearVisits > 0 ? 100.0 : 0.0;
        }

        return ((double)(currentYearVisits - lastYearVisits) / lastYearVisits) * 100;
    }


    // --------------------------------------------------------------------------------------------------------------//

    public static VisitsDTO toDTO(VisitsEntity visitEntity) {

        VisitsDTO visitsDTO = new VisitsDTO();

        visitsDTO.setVisitCountry(visitEntity.getVisitCountry());
        visitsDTO.setVisitId(visitEntity.getVisitId());
        visitsDTO.setVisitDate(visitEntity.getVisitDate());
        visitsDTO.setWebsiteVisits(visitEntity.getWebsiteVisits());

        return visitsDTO;
    }
}
