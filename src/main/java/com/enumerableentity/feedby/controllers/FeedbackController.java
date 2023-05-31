package com.enumerableentity.feedby.controllers;

import com.enumerableentity.feedby.dto.QuizAnswerDTO;
import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/qr")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/{code}")
    public ResponseEntity<QuizDTO> getQuestionsForCode(@PathVariable String code) {
        return ResponseEntity.ok(feedbackService.getQuestionsForCode(code));
    }

    @PostMapping
    public ResponseEntity<QuizAnswerDTO> leaveFeedback(@RequestBody QuizAnswerDTO quizAnswerDTO) {
        return ResponseEntity.ok(feedbackService.leaveFeedback(quizAnswerDTO));
    }

}
