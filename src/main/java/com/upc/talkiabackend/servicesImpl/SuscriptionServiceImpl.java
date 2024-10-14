package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.Suscription;
import com.upc.talkiabackend.repositories.SuscriptionRepository;
import com.upc.talkiabackend.services.SuscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuscriptionServiceImpl implements SuscriptionService {
    @Autowired
    private SuscriptionRepository suscriptionRepository;

    @Override
    public List<Suscription> listSuscriptions() {
        return suscriptionRepository.findAll();
    }


}
