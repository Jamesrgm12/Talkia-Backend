package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.ShowQuestionByLevelDTO;
import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> getQuestionsByLevel(Level level);
    @Query("select new com.upc.talkiabackend.dtos.queries.ShowQuestionByLevelDTO(q.description, q.iCreatedAt, q.iModifiedAt)from Question q where q.level.level=:level")
    List<ShowQuestionByLevelDTO> listQuestionsByLevel(String level);


}
