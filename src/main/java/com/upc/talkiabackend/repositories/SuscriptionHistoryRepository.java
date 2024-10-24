package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.CountHistoriesByObjectDTO;
import com.upc.talkiabackend.dtos.queries.TotalAmountBySubTypeDTO;
import com.upc.talkiabackend.entities.SuscriptionsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SuscriptionHistoryRepository extends JpaRepository<SuscriptionsHistory, Integer> {
    @Query("select sh from SuscriptionsHistory sh where sh.user.id =:userId and sh.status = 'Activado'")
    public SuscriptionsHistory getSuscriptionsHistoriesByActiveStatus(@Param("userId") int userId);
    @Query("select new com.upc.talkiabackend.dtos.queries.TotalAmountBySubTypeDTO(sh.suscription.name,count (sh),sum(sh.payment.amount))" +
            "from SuscriptionsHistory sh where sh.startDate between :startDate and :endDate group by sh.suscription.name")
    List<TotalAmountBySubTypeDTO> listTotalAmountBySubType(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    //Funciona
    @Query("select new com.upc.talkiabackend.dtos.queries.CountHistoriesByObjectDTO(sh.payment.paymentType.name ,count(sh)) " +
            "from SuscriptionsHistory sh where sh.startDate between :startDate and :endDate group by sh.payment.paymentType.name ")
    List<CountHistoriesByObjectDTO> countHistoriesByPaymentType(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}
