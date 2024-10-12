package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiabackend.repositories.AnswerRepository;
import com.upc.talkiabackend.services.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    public AnswerRepository answerRepository;

    @Override
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(int questionId) {
        return answerRepository.listAnswerByQuestionUser(questionId);
    }
}
