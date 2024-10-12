package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.Question;
import com.upc.talkiabackend.entities.QuizzesQuestion;
import com.upc.talkiabackend.repositories.AnswerRepository;
import com.upc.talkiabackend.repositories.QuizzesQuestionRepository;
import com.upc.talkiabackend.services.QuizzesQuestionService;
import com.upc.talkiabackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class QuizzesQuestionServiceImpl implements QuizzesQuestionService {
    @Autowired
    private QuizzesQuestionRepository qqRepository;
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserService userService;

    List<Double> pointsByLevel = Arrays.asList(20.0, 12.0, 10.0);

    @Override
    public String answerQuestion(int qqId, String userAnswer) {
        QuizzesQuestion qq = qqRepository.getQuizzesQuestionById(qqId);
        Question question = qq.getQuestion();
        Double pointsQuiz = qq.getQuiz().getTotalPoints();
        Double pointsUser = qq.getQuiz().getUser().getTotalPoints();

        if(qq.getAttempt()<2 && !qq.getIs_correct()){
            qq.setUserAnswer(userAnswer);
            qq.setAttempt(qq.getAttempt() + 1);

            if(answerRepository.getCorrectAnswerByQuestionId(question.getId()).getDescription().equals(userAnswer)) {
                double gainedPoints = 0.0;

                if (qq.getAttempt() == 1) {
                    gainedPoints = pointsByLevel.get(question.getLevel().getId()-1);


                }
                if(qq.getAttempt()== 2){
                    gainedPoints = (pointsByLevel.get(question.getLevel().getId()-1))/(2.0);

                }
                qq.setPointsEarned(gainedPoints);
                qq.setIs_correct(true);
                pointsQuiz += gainedPoints;
                qq.getQuiz().setTotalPoints(pointsQuiz);

                //pointsUser += gainedPoints;
                //qq.getQuiz().getUser().setTotalPoints(pointsUser);

                //Actualizar cuando se acabe el quiz
                //Verificar aumento de nivel

                if(qqId % 4 == 0){
                    pointsUser += qq.getQuiz().getTotalPoints();
                    qq.getQuiz().getUser().setTotalPoints(pointsUser);
                    userService.updateLevelUser(qq.getQuiz().getUser().getId());

                }


                return qq.getAttempt() == 1 ?
                        "Correct! You have earned " + gainedPoints + " points." :
                        "Now correct! You have earned " + gainedPoints + " points.";

            }

            return "Incorrect. "+ question.getFeedback();
        }

        return "Has llegado al límite de intentos permitidos";
    }
}
