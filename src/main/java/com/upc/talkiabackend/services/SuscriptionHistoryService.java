package com.upc.talkiabackend.services;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
}
