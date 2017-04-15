package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContributionRepository extends JpaRepository<Contribution, Long> {
    Contribution findById(Long id);

}
