package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.SuscriptionsHistory;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
    public SuscriptionsHistory getSuscriptionsHistoriesByActiveStatus(int userId);

}
