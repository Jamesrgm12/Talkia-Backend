package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionAdminDTO;
import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;
import com.upc.talkiabackend.entities.Answer;

import java.util.List;

public interface AnswerService {
    public Answer insertAnswer(Answer answer);
    public List<ShowAnswersByQuestionAdminDTO> listAnswerByQuestionAdmin(int questionId);
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(int questionId);
    public Answer updateAnswer(Answer answer);
  public void deleteAnswer(int id);
}
