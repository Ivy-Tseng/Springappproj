package org.iiiedu.eeit131.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.iiiedu.eeit131.model.Member;
import org.iiiedu.eeit131.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
	
	@Autowired
	EntityManager entityManager;  //等同於Hibernate 的Session
	
	
	@Override
	public List<Member> findALL(){
		String hql= "FROM Member"; //此處Member為類別名稱
		
		return entityManager.createQuery(hql, Member.class)
					        .getResultList();
		
		
	}
	

	@Override
	public Member findByMemberId(String memberId) {
		String hql= "FROM Member m WHERE m.id= :id"; 
		Member member= null;
		try {
			member= entityManager.createQuery(hql, Member.class)
					 .setParameter("id", memberId)
					 .getSingleResult();
		}catch(NoResultException e){
			;
		}catch(NonUniqueResultException e) {
			;
		}
		return member;
	}


	@Override
	public void save(Member member) {
		entityManager.persist(member);
	}


	@Override
	public Member findById(Integer id) {
		return entityManager.find(Member.class, id);
	}


	@Override
	public void update(Member member) {
		Member member0=findById(member.getPk());
		member.setAverageAmount(member0.getAverageAmount());
		member.setExtra(member0.getExtra());
		member.setCreateTime(member0.getCreateTime());
		member.setMemberGrade(member0.getMemberGrade());
		member.setMemberScore(member0.getMemberScore());
		member.setTotalAmount(member0.getTotalAmount());
		member.setTotalPoints(member0.getTotalPoints());
		entityManager.detach(member0); //==Hibernate的evict
		
		entityManager.merge(member);
		
	}
}
