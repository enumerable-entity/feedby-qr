package com.enumerableentity.feedby.repositories;

import com.enumerableentity.feedby.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
