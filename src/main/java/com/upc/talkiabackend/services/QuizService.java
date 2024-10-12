package com.upc.talkiabackend.services;

import com.upc.talkiabackend.entities.Quiz;

import java.util.List;

public interface QuizService {
    public Quiz insertQuiz(int userId);
    public List<Quiz> listQuizzes();
}
