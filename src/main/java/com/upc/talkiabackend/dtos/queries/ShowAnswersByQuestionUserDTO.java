package com.upc.talkiabackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowAnswersByQuestionUserDTO {
    private Integer id;
    private String answersDescription;

}