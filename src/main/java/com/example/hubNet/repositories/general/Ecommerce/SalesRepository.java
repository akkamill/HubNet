package com.example.hubNet.repositories.general.Ecommerce;

import com.example.hubNet.entities.general.Ecommerce.SalesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Repository
public interface SalesRepository extends JpaRepository<SalesEntity, Long> {

    @Query("SELECT SUM(s.income) FROM sales s WHERE s.saleDate >= :startOfWeek AND s.saleDate < :endOfWeek")
    BigDecimal getIncomeForCurrentWeek(LocalDateTime startOfWeek, LocalDateTime endOfWeek);

    @Query("SELECT SUM(s.income) FROM sales s WHERE s.saleDate >= :startOfLastWeek AND s.saleDate < :endOfLastWeek")
    BigDecimal getIncomeForLastWeek(LocalDateTime startOfLastWeek, LocalDateTime endOfLastWeek);

    @Query("SELECT SUM(s.profit) FROM sales s WHERE s.saleDate BETWEEN ?1 AND ?2")
    BigDecimal getProfitForCurrentWeek(LocalDateTime startDate, LocalDateTime endDate);

//    @Query("SELECT SUM(s.profit) FROM SalesEntity s WHERE s.saleDate >= :startOfLastWeek AND s.saleDate < :endOfLastWeek")
//    BigDecimal getProfitForLastWeek(LocalDateTime startOfLastWeek, LocalDateTime endOfLastWeek);
//
//    @Query("SELECT SUM(s.profit) FROM SalesEntity s WHERE s.saleDate >= :startOfWeek AND s.saleDate < :endOfWeek")
//    BigDecimal getProfitForCurrentWeek(LocalDateTime startOfWeek, LocalDateTime endOfWeek);

    @Query("SELECT SUM(s.profit) FROM sales s WHERE YEAR(s.saleDate) = YEAR(CURRENT_DATE)")
    BigDecimal getTotalProfitForCurrentYear();

    @Query("SELECT SUM(s.profit) FROM sales s WHERE YEAR(s.saleDate) = YEAR(CURRENT_DATE) - 1")
    BigDecimal getTotalProfitForLastYear();


    @Query("SELECT SUM(s.income) FROM sales s")
    BigDecimal getTotalIncome();

    @Query("SELECT SUM(s.expenses) FROM sales s")
    BigDecimal getTotalExpenses();

    @Query("SELECT SUM(s.profit) FROM sales s")
    BigDecimal getTotalProfit();
}
