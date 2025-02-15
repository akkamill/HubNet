package com.example.hubNet.controllers.general.users;

import com.example.hubNet.DTO.general.Installments.CountryInstallmentCountDTO;
import com.example.hubNet.services.general.InstallmentsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/installments")
public class InstallmentsController {

    private final InstallmentsService installmentsService;

    public InstallmentsController(InstallmentsService installmentsService) {
        this.installmentsService = installmentsService;
    }

    @GetMapping("/total")
    public ResponseEntity<Long> getTotalInstallments() {
        long totalInstallments = installmentsService.getTotalInstallments();
        return ResponseEntity.ok(totalInstallments);
    }

    @GetMapping("/comparison")
    public ResponseEntity<String> getInstallmentsComparison() {
        String comparisonResult = installmentsService.getInstallmentsComparison();
        return ResponseEntity.ok(comparisonResult);
    }

    @GetMapping("/comparison/mainlands")
    public ResponseEntity<List<Object[]>> getInstallmentsByMainlands() {
        List<Object[]> comparisonResult = installmentsService.getInstallmentsByMainlands();
        return ResponseEntity.ok(comparisonResult);
    }

    @GetMapping("/top-by-country")
    public List<CountryInstallmentCountDTO> getTopInstallmentsByCountry() {
        return installmentsService.getTopInstallmentsByCountry();
    }
}
