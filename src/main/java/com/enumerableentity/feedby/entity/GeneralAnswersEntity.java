package com.enumerableentity.feedby.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "general_answers")
public class GeneralAnswersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String customAnswer;

    private Integer ranking;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "code_id", nullable = false)
    private CodeQrEntity code;

}
