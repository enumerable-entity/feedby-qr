package com.enumerableentity.feedby.services;

import com.enumerableentity.feedby.dto.QuizAnswerDTO;
import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.entity.CodeQrEntity;
import com.enumerableentity.feedby.entity.UserAnswerEntity;
import com.enumerableentity.feedby.mapper.QuizMapper;
import com.enumerableentity.feedby.repositories.AnswerRepository;
import com.enumerableentity.feedby.repositories.CodeRepository;
import com.enumerableentity.feedby.repositories.QuestionRepository;
import com.enumerableentity.feedby.repositories.UserAnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final QuizMapper quizMapper;
    private final CodeRepository codeRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;

    public QuizDTO getQuestionsForCode(String qrcode) {
        CodeQrEntity code = codeRepository.findByCode(qrcode);

        return quizMapper.toDto(
                code.getCodeDetails().getBackgroundUrl(),
                code.getCodeDetails().getOwnerName(),
                code.getCodeDetails().getPointAddress(),
                code.getCodeDetails().getProductTitle(),
                code.getCodeDetails().getQuestions()
        );
    }

    @Transactional
    public QuizAnswerDTO leaveFeedback(QuizAnswerDTO quizAnswerDTO) {

        List<UserAnswerEntity> list = quizAnswerDTO.getQuestions().stream()
                .flatMap(questionDTO ->
                    questionDTO.getAnswers().stream()
                            .map(answerDTO -> UserAnswerEntity.builder()
                                    .question(questionRepository.getReferenceById(questionDTO.getId()))
                                    .answer(answerRepository.getReferenceById(answerDTO.getId())).build()
                )).toList();

        userAnswerRepository.saveAll(list);
        return null;
    }
}
