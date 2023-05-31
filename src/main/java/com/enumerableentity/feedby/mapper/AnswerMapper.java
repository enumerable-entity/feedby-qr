package com.enumerableentity.feedby.mapper;

import com.enumerableentity.feedby.dto.AnswerDTO;
import com.enumerableentity.feedby.entity.AnswerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AnswerMapper {

    AnswerDTO toDto(AnswerEntity answerEntity);

}
