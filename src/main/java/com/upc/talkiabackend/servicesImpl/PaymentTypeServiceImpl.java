package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.PaymentType;
import com.upc.talkiabackend.repositories.PaymentTypeRepository;
import com.upc.talkiabackend.services.PaymentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentTypeServiceImpl implements PaymentTypeService {
    @Autowired
    private PaymentTypeRepository paymentTypeRepository;

    @Override
    public List<PaymentType> listPaymentTypes() {
        return paymentTypeRepository.findAll();
    }
    @Override
    public PaymentType getPaymentTypeById(int id) {
        return paymentTypeRepository.findById(id).get();
    }

}
