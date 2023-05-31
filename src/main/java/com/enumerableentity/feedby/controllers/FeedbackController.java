package com.enumerableentity.feedby.controllers;

import com.enumerableentity.feedby.dto.QuizDTO;
import com.enumerableentity.feedby.services.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/qr")
@RequiredArgsConstructor
public class FeedbackController {
    private final FeedbackService feedbackService;

    @GetMapping("/{code}")
    public ResponseEntity<QuizDTO> getQuestionsForCode(@PathVariable String code) {
        return ResponseEntity.ok(feedbackService.getQuestionsForCode(code));
    }

}
