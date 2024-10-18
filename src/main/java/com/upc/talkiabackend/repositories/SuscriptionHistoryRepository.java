package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.SuscriptionsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptionHistoryRepository extends JpaRepository<SuscriptionsHistory, Integer> {
    @Query("select sh from SuscriptionsHistory sh where sh.user.id =:userId and sh.status = 'Activado'")
    public SuscriptionsHistory getSuscriptionsHistoriesByActiveStatus(@Param("userId") int userId);

}
