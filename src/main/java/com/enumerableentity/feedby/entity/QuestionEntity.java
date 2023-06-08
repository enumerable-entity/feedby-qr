package com.enumerableentity.feedby.entity;

import com.enumerableentity.feedby.commons.enums.QuestionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "questions")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "question")
    private List<AnswerEntity> answers;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private CodeDetailsEntity codeDetails;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "question")
    private List<AnswerEntity> userAnswer;

}
