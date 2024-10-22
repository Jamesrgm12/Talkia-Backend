package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.ShowYearlyPaymentsDTO;
import com.upc.talkiabackend.repositories.PaymentRepository;
import com.upc.talkiabackend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    public List<ShowYearlyPaymentsDTO> listPaymentsByYear(Integer userId, Integer year) {
        return paymentRepository.listPaymentsByYear(userId, year);
    }
}
