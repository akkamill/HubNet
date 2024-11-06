package com.example.ecommerceDemo.controllers.general;

import com.example.ecommerceDemo.DTO.general.application.ApplicationDTO;
import com.example.ecommerceDemo.services.general.application.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/general/applications")
public class ApplicationController {

    private final ApplicationService applicationService;

    @Autowired
    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }


    @GetMapping("/getAll")
    public List<ApplicationDTO> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/get/{id}")
    public ApplicationDTO getApplicationById(@PathVariable Long id) {
        return applicationService.getApplicationById(id);
    }


}
