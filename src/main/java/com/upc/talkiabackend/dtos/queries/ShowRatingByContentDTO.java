package com.upc.talkiabackend.dtos.queries;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShowRatingByContentDTO {
  private String content;
  private Double avgRating;
  private int year;
}
