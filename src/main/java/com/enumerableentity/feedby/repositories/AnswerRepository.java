package com.enumerableentity.feedby.repositories;

import com.enumerableentity.feedby.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
}
