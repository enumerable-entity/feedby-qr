package com.enumerableentity.feedby.mapper;

import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.entity.QuestionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {QuestionMapper.class})
public interface QuizMapper {

    QuizDTO toDto(String backgroundUrl, String ownerName, String pointAddress, String productTitle, List<QuestionEntity> questions);
}
