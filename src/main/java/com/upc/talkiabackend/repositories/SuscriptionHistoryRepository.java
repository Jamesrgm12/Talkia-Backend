package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.SuscriptionsHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptionHistoryRepository extends JpaRepository<SuscriptionsHistory, Integer> {
}
