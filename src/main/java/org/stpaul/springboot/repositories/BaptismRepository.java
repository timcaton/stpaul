package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Baptism;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaptismRepository extends JpaRepository<Baptism, Long> {
    Baptism findByName(String name);

}
