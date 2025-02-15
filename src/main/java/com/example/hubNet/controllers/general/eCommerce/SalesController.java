package com.example.hubNet.controllers.general.eCommerce;

import com.example.hubNet.services.general.Ecommerce.SalesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/general")
public class SalesController {

    private final SalesService salesService;

    public SalesController(SalesService salesService) {
        this.salesService = salesService;
    }


    @GetMapping("/weekly-sales-comparison")
    public ResponseEntity<Double> compareWeeklySales() {
        double percentageChange = salesService.compareWeeklySales();
        return ResponseEntity.ok(percentageChange);
    }

    @GetMapping("/weekly-profit-comparison")
    public ResponseEntity<Double> compareWeeklyProfit() {
        double percentageChange = salesService.compareWeeklyProfit();
        return ResponseEntity.ok(percentageChange);
    }

    @GetMapping("/total/income")
    public ResponseEntity<BigDecimal> getTotalIncome() {
        BigDecimal totalIncome = salesService.getTotalIncome();
        return ResponseEntity.ok(totalIncome);
    }

    @GetMapping("/total/expenses")
    public ResponseEntity<BigDecimal> getTotalExpenses() {
        BigDecimal totalExpenses = salesService.getTotalExpenses();
        return ResponseEntity.ok(totalExpenses);
    }

    @GetMapping("/total/profit")
    public ResponseEntity<BigDecimal> getTotalProfit() {
        BigDecimal totalProfit = salesService.getTotalProfit();
        return ResponseEntity.ok(totalProfit);
    }

    @GetMapping("/compare/profit")
    public ResponseEntity<Double> calculateProfitChangePercentage() {
        double profitChangePercentage = salesService.calculateProfitChangePercentage();
        return ResponseEntity.ok(profitChangePercentage);
    }
}
