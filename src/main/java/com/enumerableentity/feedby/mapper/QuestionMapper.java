package com.enumerableentity.feedby.mapper;

import com.enumerableentity.feedby.dto.QuestionDTO;
import com.enumerableentity.feedby.entity.QuestionEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(uses = {AnswerMapper.class})
public interface QuestionMapper {
    QuestionDTO toDto(QuestionEntity questionEntity);
    List<QuestionDTO> toDto(List<QuestionEntity> questionEntity);
}
