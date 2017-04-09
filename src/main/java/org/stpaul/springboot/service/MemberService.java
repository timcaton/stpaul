package org.stpaul.springboot.service;


import org.stpaul.springboot.model.Member;

import java.util.List;

public interface MemberService {
	
	Member findById(Long id);

	Member findByName(String name);

	void saveMember(Member member);

	void updateMember(Member member);

	void deleteMemberById(Long id);

	void deleteAllMembers();

	List<Member> findAllMembers();

	boolean isMemberExist(Member member);
}