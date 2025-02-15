package com.example.hubNet.controllers.general.eCommerce;

import com.example.hubNet.DTO.general.Ecommerce.BalanceDTO;
import com.example.hubNet.services.general.Ecommerce.BalanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/general")
public class BalanceController {


    private final BalanceService balanceService;

    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }


    @GetMapping("get/{balanceId}")
    public BalanceDTO getBalanceById(@PathVariable Long balanceId) {
        return balanceService.getBalance(balanceId);
    }
}
