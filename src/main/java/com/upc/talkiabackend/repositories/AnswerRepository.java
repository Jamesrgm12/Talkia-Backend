package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiabackend.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query("select a from Answer a where a.question.id=:questionId and a.isCorrect=true")
    Answer getCorrectAnswerByQuestionId(@Param("questionId") int questionId);
    @Query("select new com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO(a.id, a.description) from Answer a where a.question.id=:questionId")
    List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(@Param("questionId") int questionId);
}
