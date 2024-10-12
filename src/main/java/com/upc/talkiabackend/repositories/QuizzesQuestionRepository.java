package com.upc.talkiabackend.repositories;

import com.upc.talkiabackend.dtos.queries.ShowQuestionsByQuizDTO;
import com.upc.talkiabackend.entities.QuizzesQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizzesQuestionRepository extends JpaRepository<QuizzesQuestion, Integer> {
    QuizzesQuestion getQuizzesQuestionById(Integer id);
        @Query("select avg(qq.pointsEarned) " +
                "from QuizzesQuestion qq " +
                "where qq.quiz.user.id=:userId")
        public Double getAveragePoints(@Param("userId") int userId);

        @Query("select count(distinct qq.quiz.id) from QuizzesQuestion qq where qq.quiz.user.id=:userId")
        public Long getTotalQuizzesCompleted(@Param("userId") int userId);
        @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.user.id = :userId")
        public Long getTotalQuestions(@Param("userId") int userId);


        @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.user.id = :userId and qq.is_correct = true")
        public Long getTotalCorrectAnswers(@Param("userId") int userId);


    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.id=:quizId and qq.is_correct=true")
    public Integer getCorrectAnswersCount(@Param("quizId") int quizId);

    @Query("select count(qq) from QuizzesQuestion qq where qq.quiz.id=:quizId and qq.attempt=2 and qq.is_correct=true")
    public Integer getSecondAttemptCorrectAnswers(@Param("quizId") int quizId);

    @Query("select new com.upc.talkiabackend.dtos.queries.ShowQuestionsByQuizDTO(qq.id,qq.question.id ,qq.question.description)" +
            "from QuizzesQuestion qq where qq.quiz.id =:quizId")
    List<ShowQuestionsByQuizDTO> listQuestionsByQuizId(@Param("quizId") int quizId);


}
