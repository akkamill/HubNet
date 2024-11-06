package com.example.ecommerceDemo.services.general;

import com.example.ecommerceDemo.DTO.general.Installments.CountryInstallmentCountDTO;
import com.example.ecommerceDemo.repositories.general.InstallmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstallmentsService {

    private final InstallmentsRepository installmentsRepository;

    @Autowired
    public InstallmentsService(InstallmentsRepository installmentsRepository) {
        this.installmentsRepository = installmentsRepository;
    }

    public long getTotalInstallments() {
        return installmentsRepository.count();
    }

    public List<Object[]> getInstallmentsByMainlands() {
        return installmentsRepository.countByMainlandsGroupBy(); // Implement this method in your repository
    }

    public List<CountryInstallmentCountDTO> getTopInstallmentsByCountry() {
        List<Object[]> results = installmentsRepository.findTopInstallmentsByCountry(PageRequest.of(0, 5));
        return results.stream()
                .map(result -> new CountryInstallmentCountDTO((String) result[0], (Long) result[1]))
                .toList();
    }

    public String getInstallmentsComparison() {
        LocalDateTime sixMonthsAgo = LocalDateTime.now().minusMonths(6);
        long currentCount = installmentsRepository.count(); // You can filter based on date range
        long lastSixMonthsCount = installmentsRepository.countByCreatedAtAfter(sixMonthsAgo);

        if (lastSixMonthsCount > currentCount) {
            return "Installments have increased compared to the previous six months.";
        } else if (lastSixMonthsCount < currentCount) {
            return "Installments have decreased compared to the previous six months.";
        } else {
            return "Installments remain the same compared to the previous six months.";

        }
    }
}