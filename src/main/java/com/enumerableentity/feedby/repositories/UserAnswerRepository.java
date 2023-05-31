package com.enumerableentity.feedby.repositories;

import com.enumerableentity.feedby.entity.UserAnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAnswerRepository extends JpaRepository<UserAnswerEntity, Long> {
}
