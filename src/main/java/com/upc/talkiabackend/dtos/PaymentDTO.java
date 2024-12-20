package com.upc.talkiabackend.dtos;

import com.upc.talkiabackend.entities.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Integer id;
    private PaymentType paymentType;
    private Double amount;
    private LocalDateTime date;
}