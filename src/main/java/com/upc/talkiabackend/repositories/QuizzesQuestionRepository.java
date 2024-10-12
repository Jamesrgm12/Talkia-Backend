package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.QuizzesQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzesQuestionRepository extends JpaRepository<QuizzesQuestion, Integer> {
    QuizzesQuestion getQuizzesQuestionById(Integer id);


}
