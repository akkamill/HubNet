package com.example.hubNet.controllers.general.analytics;

import com.example.hubNet.services.general.analytics.MixtureService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/analytics")
public class MixtureController {

    private final MixtureService mixtureService;

    public MixtureController(MixtureService mixtureService) {
        this.mixtureService = mixtureService;
    }


    @GetMapping("/mixtureIds/{userId}")
    public List<Long> getMixtureIds(@PathVariable Long userId) {
        return mixtureService.getMixtureIds(userId);
    }

    // Endpoint to get all weekly sales for a user
    @GetMapping("/weeklySales/{userId}")
    public List<Integer> getWeeklySales(@PathVariable Long userId) {
        return mixtureService.getWeeklySales(userId);
    }

    // Endpoint to get all new users for a user
    @GetMapping("/newUsers/{userId}")
    public List<Integer> getNewUsers(@PathVariable Long userId) {
        return mixtureService.getNewUsers(userId);
    }

    // Endpoint to get all item orders for a user
    @GetMapping("/itemOrders/{userId}")
    public List<Integer> getItemOrders(@PathVariable Long userId) {
        return mixtureService.getItemOrders(userId);
    }

    // Endpoint to get all bug reports for a user
    @GetMapping("/bugReports/{userId}")
    public List<Integer> getBugReports(@PathVariable Long userId) {
        return mixtureService.getBugReports(userId);
    }
}
