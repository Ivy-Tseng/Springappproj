package org.iiiedu.eeit131.service;

import java.util.List;

import org.iiiedu.eeit131.model.Member;

public interface MemberService {

	List<Member> findAll();

	Member findByMemberId(String memberId);


	void save(Member member);

	Member findById(Integer id);

	void update(Member member);

}