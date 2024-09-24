package com.rb.ppm.core.repository;

import com.rb.ppm.core.domain.OfficerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfficerRepository extends JpaRepository<OfficerEntity, Long> {
    Optional<OfficerEntity> findByUserName(String username);
}
