package com.enumerableentity.feedby.dto;

import com.enumerableentity.feedby.commons.enums.QuestionType;
import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private QuestionType type;
    private List<AnswerDTO> answers;
}
