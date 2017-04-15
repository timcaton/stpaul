package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Communion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommunionRepository extends JpaRepository<Communion, Long> {
    Communion findById(Long id);
}