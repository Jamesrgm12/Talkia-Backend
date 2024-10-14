package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.Suscription;

import java.util.List;

public interface SuscriptionService {
    public List<Suscription> listSuscriptions();
    public Suscription getSuscriptionById(int susId);

}
