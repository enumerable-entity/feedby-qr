package com.enumerableentity.feedby.services;

import com.enumerableentity.feedby.dto.QuestionDTO;
import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.mapper.QuestionMapper;
import com.enumerableentity.feedby.mapper.QuizMapper;
import com.enumerableentity.feedby.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final QuizMapper quizMapper;
    private final QuestionRepository questionRepository;
    public QuizDTO getQuestionsForCode(String code) {
//        var questions = questionRepository.findAll();
//
//        return quizMapper.toDto(questionRepository.findAll());
        return null;
    }
}
