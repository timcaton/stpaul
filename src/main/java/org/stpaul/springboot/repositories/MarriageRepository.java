package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Marriage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarriageRepository extends JpaRepository<Marriage, Long> {
    Marriage findById(Long id);
}