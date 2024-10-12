package com.upc.talkiabackend.services;

public interface QuizzesQuestionService {
    public String answerQuestion(int qqId, String userAnswer);
    public Double getAveragePoints(int userId);
    public Long getTotalQuizzesCompleted(int userId);
    public Double getAverageCorrectAnswers(int userId);


}
