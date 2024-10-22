package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.UserContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserContentRepository extends JpaRepository<UserContent, Integer> {
}
