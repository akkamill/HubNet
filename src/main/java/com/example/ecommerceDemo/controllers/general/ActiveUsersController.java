package com.example.ecommerceDemo.controllers.general;

import com.example.ecommerceDemo.services.general.ActiveUsersService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/active-users")
public class ActiveUsersController {

    private final ActiveUsersService activeUsersService;

    public ActiveUsersController(ActiveUsersService activeUsersService) {
        this.activeUsersService = activeUsersService;
    }

    @GetMapping("/count")
    public long getActiveUsersCount() {
        return activeUsersService.countActiveUsers();
    }
}