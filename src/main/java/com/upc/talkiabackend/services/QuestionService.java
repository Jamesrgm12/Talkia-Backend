package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowQuestionByLevelDTO;
import com.upc.talkiabackend.entities.Question;

import java.util.List;

public interface QuestionService {
    public List<Question> listQuestions();
    public Question insertQuestion(Question question);
    List<ShowQuestionByLevelDTO> listQuestionsByLevel(String level);

}
