package com.upc.talkiabackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShowQuestionByLevelDTO {
    private String description;
    private LocalDateTime iCreatedAt;
    private LocalDateTime iModifiedAt;
}
