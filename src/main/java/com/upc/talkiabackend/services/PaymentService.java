package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowYearlyPaymentsDTO;

import java.util.List;

public interface PaymentService {
    public List<ShowYearlyPaymentsDTO> listPaymentsByYear(Integer userId, Integer year);
}
