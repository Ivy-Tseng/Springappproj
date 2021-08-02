package org.iiiedu.eeit131.service.impl;

import java.util.List;

import org.iiiedu.eeit131.model.Member;
import org.iiiedu.eeit131.repository.MemberRepository;
import org.iiiedu.eeit131.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	
	@Override
	public List<Member> findAll(){
		return memberRepository.findALL();
	}

	@Override
	public Member findByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public void save(Member member) {
		if(memberRepository.findByMemberId(member.getId()) !=null) {
			  throw new RuntimeException("帳號已存在,請更換新帳號");
		}else {
			memberRepository.save(member);
		}
	}

	@Override
	public Member findById(Integer id) {
		return memberRepository.findById(id);
	}

	@Override
	public void update(Member member) {
		
		memberRepository.update(member);
		
	}

}
