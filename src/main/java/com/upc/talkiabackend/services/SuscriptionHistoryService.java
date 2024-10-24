package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.CountHistoriesByObjectDTO;
import com.upc.talkiabackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiabackend.dtos.queries.TotalAmountBySubTypeDTO;
import com.upc.talkiabackend.entities.SuscriptionsHistory;

import java.time.LocalDate;
import java.util.List;

public interface SuscriptionHistoryService {
    public String insertInManyToManyTable(int userID, int suscriptionID, int paymentTypeId);
    public SuscriptionsHistory getSuscriptionsHistoriesByActiveStatus(int userId);
    public List<CountHistoriesByObjectDTO> countHistoriesByPaymentType(LocalDate startDate, LocalDate endDate);
    public List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(LocalDate startDate, LocalDate endDate);
    public List<HistoryByObjectDTO> listHistoryByUser(int userId);


}
