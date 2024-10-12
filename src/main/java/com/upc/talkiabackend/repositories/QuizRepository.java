package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.entities.Question;
import com.upc.talkiabackend.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {

}
