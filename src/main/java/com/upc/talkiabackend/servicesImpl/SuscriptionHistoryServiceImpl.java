package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.CountHistoriesByObjectDTO;
import com.upc.talkiabackend.dtos.queries.HistoryByObjectDTO;
import com.upc.talkiabackend.dtos.queries.TotalAmountBySubTypeDTO;
import com.upc.talkiabackend.entities.*;
import com.upc.talkiabackend.repositories.*;
import com.upc.talkiabackend.services.SuscriptionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class SuscriptionHistoryServiceImpl implements SuscriptionHistoryService {
    @Autowired
    private SuscriptionHistoryRepository shRepository;

    @Autowired
    private SuscriptionRepository suRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentTypeRepository paymentTypeRepository;


    @Override
    @Transactional
    public String insertInManyToManyTable(int userId, int susId, int paymentTypeId) {

//Ubicar al user
        User user = userRepository.getUserById(userId);

        //Cambiar estado de suscripción activa
        SuscriptionsHistory shActive = shRepository.getSuscriptionsHistoriesByActiveStatus(userId);
        if(shActive!=null && shActive.getStatus().equals("Activado")){
            shActive.setStatus("Finalizado");
            shActive.setEndDate(LocalDate.now());
            shRepository.save(shActive);
        }
        //Seleccionar suscripcion
        Suscription sus = suRepository.getSuscriptionById(susId);
        //Seleccionar tipo de pago
        PaymentType paymentType = paymentTypeRepository.getPaymentTypeById(paymentTypeId);
        //Crear pago
        Payment payment = new Payment();
        payment.setPaymentType(paymentType);
        payment.setAmount(sus.getPrice());
        payment.setDate(LocalDateTime.now());
        //Insertar pago
        paymentRepository.save(payment);
        //Crear objeto SuscriptionsHistory
        SuscriptionsHistory sh = new SuscriptionsHistory();
        sh.setStartDate(LocalDate.now());
        LocalDate endDate=LocalDate.now();
        if(sus.getName().equals("Mensual")){
            endDate = LocalDate.now().plusMonths(1);
        }if(sus.getName().equals("Semestral")){
            endDate = LocalDate.now().plusMonths(6);
        }if(sus.getName().equals("Anual")){

            endDate = LocalDate.now().plusYears(1);
        }
        sh.setEndDate(endDate);
        sh.setStatus("Activado");
        sh.setUser(user);
        sh.setSuscription(sus);
        sh.setPayment(payment);
        shRepository.save(sh);
        return "Se ha confirmado exitosamente la suscripción al plan " + sus.getName();




    }

    @Override
    public SuscriptionsHistory getSuscriptionsHistoriesByActiveStatus(int userId){
        return shRepository.getSuscriptionsHistoriesByActiveStatus(userId);
    }
    public List<CountHistoriesByObjectDTO> countHistoriesByPaymentType(LocalDate startDate, LocalDate endDate) {
        return shRepository.countHistoriesByPaymentType(startDate, endDate);
    }

    @Override
    public List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(LocalDate startDate, LocalDate endDate) {
        return shRepository.listTotalAmountBySubType(startDate, endDate);
    }
    @Override
    public List<HistoryByObjectDTO> listHistoryByUser(int userId) {
        return shRepository.listHistoryByUser(userId);
    }
    @Override
    public List<HistoryByObjectDTO> listHistoryByUserAndSuscription(int userId, String suscriptionName) {
        return shRepository.listHistoryByUserAndSuscription(userId, suscriptionName);
    }
    @Override
    public List<HistoryByObjectDTO> listHistoryByPaymentType(String paymentTypeName) {
        return shRepository.listHistoryByPaymentType(paymentTypeName);
    }
    @Override
    public List<HistoryByObjectDTO> listHistoryBySuscription(String suscriptionName) {
        return shRepository.listHistoryBySuscription(suscriptionName);
    }

    @Override
    public List<HistoryByObjectDTO> listHistoryByPaymentTypeAndSuscription(String paymentTypeName, String suscriptionName) {
        return shRepository.listHistoryByPaymentTypeAndSuscription(paymentTypeName, suscriptionName);
    }

    @Override
    public List<HistoryByObjectDTO> listHistoryByUserAndPaymentType(int userId, String paymentTypeName) {
        return shRepository.listHistoryByUserAndPaymentType(userId, paymentTypeName);
    }

    @Override
    public List<HistoryByObjectDTO> listHistoryByAllFilters(int userId, String paymentTypeName, String suscriptionName){
        return shRepository.listHistoryByAllFilters(userId, paymentTypeName, suscriptionName);
    }

}
