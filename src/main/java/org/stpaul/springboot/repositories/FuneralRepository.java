package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Funeral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuneralRepository extends JpaRepository<Funeral, Long> {
    Funeral findById(Long id);
}