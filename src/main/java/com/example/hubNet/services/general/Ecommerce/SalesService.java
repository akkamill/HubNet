package com.example.hubNet.services.general.Ecommerce;

import com.example.hubNet.DTO.general.Ecommerce.SalesDTO;
import com.example.hubNet.entities.general.Ecommerce.SalesEntity;
import com.example.hubNet.repositories.general.Ecommerce.SalesRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

@Service
public class SalesService {


    private final SalesRepository salesRepository;

    public SalesService(SalesRepository salesRepository) {
        this.salesRepository = salesRepository;
    }

    @Transactional
    public double compareWeeklySales() {

        LocalDateTime startOfCurrentWeek = LocalDateTime.now().with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDateTime endOfCurrentWeek = startOfCurrentWeek.plusWeeks(1);

        LocalDateTime startOfLastWeek = startOfCurrentWeek.minusWeeks(1);
        LocalDateTime endOfLastWeek = startOfCurrentWeek;

        BigDecimal currentWeekIncome = salesRepository.getIncomeForCurrentWeek(startOfCurrentWeek, endOfCurrentWeek);
        BigDecimal lastWeekIncome = salesRepository.getIncomeForLastWeek(startOfLastWeek, endOfLastWeek);

        if (lastWeekIncome.compareTo(BigDecimal.ZERO) == 0) {
            return currentWeekIncome.compareTo(BigDecimal.ZERO) > 0 ? 100.0 : 0.0;
        }

        return currentWeekIncome.subtract(lastWeekIncome)
                .divide(lastWeekIncome, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }

    @Transactional
    public double compareWeeklyProfit() {
        LocalDateTime startOfCurrentWeek = LocalDateTime.now().with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
        LocalDateTime endOfCurrentWeek = startOfCurrentWeek.plusWeeks(1);

        LocalDateTime startOfLastWeek = startOfCurrentWeek.minusWeeks(1);
        LocalDateTime endOfLastWeek = startOfCurrentWeek;

        BigDecimal currentWeekProfit = salesRepository.getProfitForCurrentWeek(startOfCurrentWeek, endOfCurrentWeek);
        BigDecimal lastWeekProfit = salesRepository.getProfitForCurrentWeek(startOfLastWeek, endOfLastWeek);

        if (lastWeekProfit.compareTo(BigDecimal.ZERO) == 0) {
            return currentWeekProfit.compareTo(BigDecimal.ZERO) > 0 ? 100.0 : 0.0;
        }

        BigDecimal profitDifference = currentWeekProfit.subtract(lastWeekProfit);
        return profitDifference
                .divide(lastWeekProfit, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }

    @Transactional
    public double calculateProfitChangePercentage() {
        BigDecimal currentYearProfit = salesRepository.getTotalProfitForCurrentYear();
        BigDecimal lastYearProfit = salesRepository.getTotalProfitForLastYear();

        return calculatePercentageChange(currentYearProfit, lastYearProfit);
    }

    @Transactional
    public double calculatePercentageChange(BigDecimal currentValue, BigDecimal lastValue) {
        if (lastValue == null || lastValue.compareTo(BigDecimal.ZERO) == 0) {
            return currentValue != null && currentValue.compareTo(BigDecimal.ZERO) > 0 ? 100.0 : 0.0;
        }

        return currentValue.subtract(lastValue)
                .divide(lastValue, BigDecimal.ROUND_HALF_UP)
                .multiply(BigDecimal.valueOf(100))
                .doubleValue();
    }


    public BigDecimal getTotalIncome() {
        return salesRepository.getTotalIncome();
    }

    public BigDecimal getTotalExpenses() {
        return salesRepository.getTotalExpenses();
    }

    public BigDecimal getTotalProfit() {
        return salesRepository.getTotalProfit();
    }


    //    ---------------------------------------------------------------------------------------------------------------//
    public static SalesDTO toDTO(SalesEntity salesEntity) {
        SalesDTO dto = new SalesDTO();
        dto.setSalesId(salesEntity.getSalesId());
        dto.setProfit(salesEntity.getProfit());
        dto.setIncome(salesEntity.getIncome());
        dto.setExpenses(salesEntity.getExpenses());
        dto.setSaleDate(salesEntity.getSaleDate());
        if (salesEntity.getUser() != null) {
            dto.setUserId(salesEntity.getUser().getUserId());
        }
        return dto;
    }

    public static SalesEntity toEntity(SalesDTO salesDTO) {
        SalesEntity salesEntity = new SalesEntity();
        salesEntity.setSalesId(salesDTO.getSalesId());
        salesEntity.setProfit(salesDTO.getProfit());
        salesEntity.setIncome(salesDTO.getIncome());
        salesEntity.setExpenses(salesDTO.getExpenses());
        salesEntity.setSaleDate(salesDTO.getSaleDate());
        // You may need to set the user entity based on the userId if required
        return salesEntity;
    }

}
