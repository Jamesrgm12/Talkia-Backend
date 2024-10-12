package com.upc.talkiabackend.services;

import com.upc.talkiabackend.dtos.queries.ShowAnswersByQuestionUserDTO;

import java.util.List;

public interface AnswerService {
    public List<ShowAnswersByQuestionUserDTO> listAnswerByQuestionUser(int questionId);
}
