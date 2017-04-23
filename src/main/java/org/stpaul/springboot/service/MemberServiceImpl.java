package org.stpaul.springboot.service;

import java.util.List;

import org.stpaul.springboot.model.Member;
import org.stpaul.springboot.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("memberService")
@Transactional
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;

	public Member findById(Long id) {
		return memberRepository.findOne(id);
	}

	@Override
	public Member findByName(String name) {
		return null;
	}

	public void saveMember(Member member) {
		memberRepository.save(member);
	}

	public void updateMember(Member member){
		saveMember(member);
	}

	public void deleteMemberById(Long id){
		memberRepository.delete(id);
	}

	public void deleteAllMembers(){
		memberRepository.deleteAll();
	}

	public List<Member> findAllMembers(){
		return memberRepository.findAll();
	}

	public boolean isMemberExist(Member member) {

		if(member.getId() != null) {
			return true;
		}
		else return false;
	}

}
