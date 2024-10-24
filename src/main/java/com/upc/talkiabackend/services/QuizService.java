package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.AveragePointsLevelDTO;
import com.upc.talkiabackend.dtos.queries.QuizzesPerLevelDTO;
import com.upc.talkiabackend.entities.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz insertQuiz(int userId);
    public List<Quiz> listQuizzes();
    public List<Quiz> listQuizzesByUserId(int userId);
    public List<AveragePointsLevelDTO> listAveragePoints();
    public List<QuizzesPerLevelDTO> listQuizzesPerLevel();

}
