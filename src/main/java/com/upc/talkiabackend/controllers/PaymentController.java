package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiabackend.services.PaymentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    private final ModelMapper modelMapper = new ModelMapper();

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/paymentbyyear/{userId}/{year}")
    public ResponseEntity<?> listPaymentsByYear( @PathVariable Integer userId, @PathVariable Integer year) {
        try {
            List<ShowYearlyPaymentsDTO> paymentsDTOs = paymentService.listPaymentsByYear(userId, year);
            return new ResponseEntity<>(paymentsDTOs, HttpStatus.OK);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
