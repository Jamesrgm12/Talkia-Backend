package com.upc.talkiabackend.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SuscriptionDTO {
    private Integer id;
    private String name;
    private Double price;
    private Integer durationMonths;

}
