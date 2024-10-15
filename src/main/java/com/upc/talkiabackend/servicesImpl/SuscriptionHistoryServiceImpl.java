package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.PaymentType;
import com.upc.talkiabackend.entities.Suscription;
import com.upc.talkiabackend.entities.SuscriptionsHistory;
import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.repositories.PaymentTypeRepository;
import com.upc.talkiabackend.repositories.SuscriptionHistoryRepository;
import com.upc.talkiabackend.repositories.SuscriptionRepository;
import com.upc.talkiabackend.repositories.UserRepository;
import com.upc.talkiabackend.services.SuscriptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class SuscriptionHistoryServiceImpl implements SuscriptionHistoryService {
    @Autowired
    private SuscriptionHistoryRepository shRepository;

    @Autowired
    private SuscriptionRepository suRepository;

    @Autowired
    private UserRepository userRepository;

    //@Autowired
    //private PaymentRepository paymentRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;


    @Override
    @Transactional
    public String insertInManyToManyTable(int userId, int susId, int paymentTypeId) {


        return "Se ha confirmado exitosamente la suscripción al plan ";  //+ sus.getName();


    }
}
