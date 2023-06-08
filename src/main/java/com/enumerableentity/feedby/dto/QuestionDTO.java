package com.enumerableentity.feedby.dto;

import com.enumerableentity.feedby.commons.enums.QuestionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;

@Data
public class QuestionDTO {
    private Long id;
    private String title;
    private QuestionType type;
    private List<AnswerDTO> answers;

    @JsonProperty(access = WRITE_ONLY)
    private Long answerId;
    @JsonProperty(access = WRITE_ONLY)
    private Boolean answer;
}
