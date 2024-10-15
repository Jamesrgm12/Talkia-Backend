package com.upc.talkiabackend.controllers;

import com.upc.talkiabackend.entities.PaymentType;
import com.upc.talkiabackend.services.PaymentTypeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentTypeController {

    @Autowired
    private PaymentTypeService paymentTypeService;

    private final ModelMapper modelMapper = new ModelMapper();
    @GetMapping("/paymentsType")
    public PaymentType listPaymentsType(){
        return null;
    }
}
