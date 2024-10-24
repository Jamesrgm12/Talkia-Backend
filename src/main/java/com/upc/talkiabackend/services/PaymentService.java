package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiabackend.entities.Payment;

import java.util.List;

public interface PaymentService {
    public List<ShowYearlyPaymentsDTO> listPaymentsByYear(Integer userId, Integer year);
    public List<ShowYearlyPaymentsDTO> listPaymentsByUser(Integer userId);
    public List<Payment> listPayments();

}
