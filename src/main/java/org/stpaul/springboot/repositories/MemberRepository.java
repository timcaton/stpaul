package org.stpaul.springboot.repositories;

import org.stpaul.springboot.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByName(String name);

}
