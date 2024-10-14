package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.Suscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuscriptionRepository extends JpaRepository<Suscription, Integer> {
}
