package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Household;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseholdRepository extends JpaRepository<Household, Long> {

    Household findByName(String name);

}
