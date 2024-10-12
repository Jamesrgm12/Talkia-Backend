package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowQuestionsByQuizDTO;

import java.util.List;

public interface QuizzesQuestionService {
    public String answerQuestion(int qqId, String userAnswer);
    public Double getAveragePoints(int userId);
    public Long getTotalQuizzesCompleted(int userId);
    public Double getAverageCorrectAnswers(int userId);
    public Integer getSecondAttemptCorrectAnswers(int quizId);
    public Integer getCorrectAnswersCount(int quizId);
    public Double getPercentageCorrectAnswers(int quizId);
    public List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(int quizId);

}
