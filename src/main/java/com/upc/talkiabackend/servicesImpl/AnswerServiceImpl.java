package com.upc.talkiabackend.servicesImpl;

import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiabackend.entities.Answer;
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
    @Override
    public Answer insertAnswer(Answer answer){
        return answerRepository.save(answer);
    }
    @Override
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(int questionId) {
        return answerRepository.listAnswerByQuestionAdmin(questionId);
    }
    @Override
    public Answer updateAnswer(Answer answer){
        if(answerRepository.existsById(answer.getId())){
            return answerRepository.save(answer);
        }
        return null;
    }

}
