package com.enumerableentity.feedby.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizAnswerDTO {
    private Integer ranking;
    private String customAnswer;
    private List<QuestionDTO> questions;

}
