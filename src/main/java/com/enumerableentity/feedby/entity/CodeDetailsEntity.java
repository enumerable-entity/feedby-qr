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
    @JoinColumn(name = "code_id", referencedColumnName = "id")
    private CodeQrEntity code;

    @Column(name = "point_address", nullable = true)
    private String pointAddress;

    @Column(name = "owner_name", nullable = true)
    private String ownerName;

    @Column(name = "product_title", nullable = true)
    private String productTitle;

    @Column(name = "background_url", nullable = true)
    private String backgroundUrl;

    @OneToMany(orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "code_details_id", referencedColumnName = "id")
    private List<QuestionEntity> questions;
}
