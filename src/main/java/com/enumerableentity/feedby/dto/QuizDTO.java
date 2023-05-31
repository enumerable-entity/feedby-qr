package com.enumerableentity.feedby.dto;

import lombok.Data;

import java.util.List;

@Data
public class QuizDTO {
    private String pointAddress;
    private String productTitle;
    private String ownerName;
    private String backgroundUrl;
    private List<QuestionDTO> questions;
}
