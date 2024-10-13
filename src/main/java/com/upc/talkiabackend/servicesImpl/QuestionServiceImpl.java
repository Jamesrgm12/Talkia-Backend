package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.entities.Question;
import com.upc.talkiabackend.repositories.QuestionRepository;
import com.upc.talkiabackend.services.QuestionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> listQuestions(){
        return questionRepository.findAll();
    }

    @Override
    @Transactional
    public Question insertQuestion(Question question) {
        return questionRepository.save(question);
    }

}
