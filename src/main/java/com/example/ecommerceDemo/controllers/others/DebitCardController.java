package com.example.ecommerceDemo.controllers.others;


import com.example.ecommerceDemo.DTO.others.DebitCardDTO;
import com.example.ecommerceDemo.entities.others.DebitCardEntity;
import com.example.ecommerceDemo.services.others.DebitCardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/debitCards")
public class DebitCardController {

    private final DebitCardService debitCardService;

    public DebitCardController(DebitCardService debitCardService) {
        this.debitCardService = debitCardService;
    }

    @PostMapping("/create")
    public ResponseEntity<DebitCardEntity> createDebitCard(@RequestBody DebitCardDTO debitCardDTO) {
        return ResponseEntity.ok(debitCardService.createDebitCard(debitCardDTO));
    }
}
