package com.enumerableentity.feedby.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_answers")
public class UserAnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = true)
    private AnswerEntity answer;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    private QuestionEntity question;

    @Column(name = "yes_no_answer", nullable = true)
    private Boolean yesNoAnswer;

}
