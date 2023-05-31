package com.enumerableentity.feedby.repositories;

import com.enumerableentity.feedby.entity.CodeQrEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeRepository extends JpaRepository<CodeQrEntity, Long> {

    CodeQrEntity findByCode(String code);
}
