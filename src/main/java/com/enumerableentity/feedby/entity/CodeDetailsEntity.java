package com.enumerableentity.feedby.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "code_details")
public class CodeDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, optional = false)
    private CodeQrEntity code;

    @Column(name = "pointAddress", nullable = true)
    private String pointAddress;

    @Column(name = "ownerName", nullable = true)
    private String ownerName;

    @Column(name = "productTitle", nullable = true)
    private String productTitle;

    @Column(name = "background_url", nullable = true)
    private String backgroundUrl;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "codeDetails")
    private List<QuestionEntity> questions;
}
