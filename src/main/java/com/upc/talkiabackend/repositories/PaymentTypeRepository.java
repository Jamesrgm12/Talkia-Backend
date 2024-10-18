package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentTypeRepository extends JpaRepository<PaymentType, Integer> {
    public PaymentType getPaymentTypeById(int id);

}
