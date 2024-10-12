package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a from Answer a where a.question.id=:questionId and a.isCorrect=true")
    Answer getCorrectAnswerByQuestionId(@Param("questionId") int questionId);

}
