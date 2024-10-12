package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.entities.Level;
import com.upc.talkiabackend.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> getQuestionsByLevel(Level level);
}
