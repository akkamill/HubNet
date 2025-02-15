package com.example.hubNet.controllers.home;

import com.example.hubNet.DTO.home.SupportDTO;
import com.example.hubNet.services.home.SupportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/support")
public class SupportController {

    private final SupportService supportService;


    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping("/create")
    public ResponseEntity<SupportDTO> createMessage(@RequestBody SupportDTO supportDTO) {
        return ResponseEntity.ok(supportService.createMessage(supportDTO));
    }

}
