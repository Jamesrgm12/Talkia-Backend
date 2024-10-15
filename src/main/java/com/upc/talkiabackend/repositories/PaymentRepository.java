package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {



}
