package com.enumerableentity.feedby.controllers;

import com.enumerableentity.feedby.dto.QuizAnswerDTO;
import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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

    @PostMapping("/{code}")
    public ResponseEntity<Void> leaveFeedback(@RequestBody QuizAnswerDTO quizAnswerDTO, @PathVariable String code) {
        feedbackService.leaveFeedback(quizAnswerDTO, code);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
