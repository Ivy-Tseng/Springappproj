package org.iiiedu.eeit131.repository;

import java.util.List;

import org.iiiedu.eeit131.model.Member;

public interface MemberRepository {

	List<Member> findALL();

	Member findByMemberId(String memberId);

	void save(Member member);

	Member findById(Integer id);

	void update(Member member);

}