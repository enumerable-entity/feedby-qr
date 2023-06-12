package com.enumerableentity.feedby.services;

import com.enumerableentity.feedby.commons.enums.QuestionType;
import com.enumerableentity.feedby.dto.QuizAnswerDTO;
import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.entity.CodeQrEntity;
import com.enumerableentity.feedby.entity.GeneralAnswersEntity;
import com.enumerableentity.feedby.entity.UserAnswerEntity;
import com.enumerableentity.feedby.mapper.QuizMapper;
import com.enumerableentity.feedby.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedbackService {
    private final QuizMapper quizMapper;
    private final CodeRepository codeRepository;
    private final UserAnswerRepository userAnswerRepository;
    private final QuestionRepository questionRepository;
    private final AnswerRepository answerRepository;
    private final GeneralAnswersRepository generalAnswersRepository;

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
    public void leaveFeedback(QuizAnswerDTO quizAnswerDTO, String qrCode) {

        List<UserAnswerEntity> list = quizAnswerDTO.getQuestions().stream()
                .map(questionDTO -> UserAnswerEntity.builder()
                        .question(questionRepository.getReferenceById(questionDTO.getId()))
                        .answer(questionDTO.getType().equals(QuestionType.YES_NO) ? null :
                                answerRepository.getReferenceById(questionDTO.getAnswerId()))
                        .yesNoAnswer(questionDTO.getType().equals(QuestionType.YES_NO) ?
                                questionDTO.getAnswer() : null)
                        .build()
                ).toList();
        CodeQrEntity code = codeRepository.findByCode(qrCode);
        generalAnswersRepository.save(GeneralAnswersEntity.builder()
                .customAnswer(quizAnswerDTO.getCustomAnswer())
                .ranking(quizAnswerDTO.getRanking())
                .code(code)
                .build());
        userAnswerRepository.saveAll(list);
    }
}
