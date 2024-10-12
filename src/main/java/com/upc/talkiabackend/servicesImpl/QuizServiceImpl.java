package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.Question;
import com.upc.talkiabackend.entities.Quiz;
import com.upc.talkiabackend.entities.QuizzesQuestion;
import com.upc.talkiabackend.entities.User;
import com.upc.talkiabackend.repositories.QuestionRepository;
import com.upc.talkiabackend.repositories.QuizRepository;
import com.upc.talkiabackend.repositories.QuizzesQuestionRepository;
import com.upc.talkiabackend.repositories.UserRepository;
import com.upc.talkiabackend.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    private QuizRepository quizRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private QuizzesQuestionRepository qqRepository;

    @Override
    public Quiz insertQuiz(int userId) {
        User user = userRepository.getUserById(userId);
        Quiz quiz = new Quiz();
        quiz.setUser(user);
        quiz.setTotalPoints(0.0);
        quizRepository.save(quiz);
        List<Question> availableQuestions =questionRepository.getQuestionsByLevel(user.getLevel());
        Collections.shuffle(availableQuestions);
        Set<Question> selectedQuestions = new HashSet<>();

        for(Question question : availableQuestions) {
            if (selectedQuestions.size() < 4) {
                selectedQuestions.add(question);
            } else {
                break;
            }
        }

        for (Question question : selectedQuestions) {
            QuizzesQuestion quizzesQuestion = new QuizzesQuestion();
            quizzesQuestion.setQuiz(quiz);
            quizzesQuestion.setAttempt(0); // Iniciar con 0 intentos
            quizzesQuestion.setUserAnswer(""); // Respuesta vacía al inicio
            quizzesQuestion.setPointsEarned(0.0); // Iniciar con 0 puntos
            quizzesQuestion.setQuestion(question); // Asignar la pregunta seleccionada
            quizzesQuestion.setIs_correct(false);
            qqRepository.save(quizzesQuestion);
        }

        return quiz;
    }
    @Override
    public List<Quiz> listQuizzes() {
        return quizRepository.findAll();
    }
}
