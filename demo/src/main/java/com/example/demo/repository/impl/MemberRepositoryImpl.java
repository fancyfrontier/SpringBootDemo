package com.example.demo.repository.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;

@Repository
@Transactional
public class MemberRepositoryImpl implements MemberRepository {

	@Autowired
	EntityManager entityManager;

	@Override
	public List<Member>  findAll(){
		String hql = "FROM   Member";
		return entityManager.createQuery(hql, Member.class)
				            .getResultList();
	}

	@Override
	public Member findByMemberId(String memberId) {
		String hql = "FROM Member m WHERE m.id = :id";
		Member member = null;
		try {
			member = entityManager.createQuery(hql, Member.class)
		                          .setParameter("id", memberId)
		                          .getSingleResult();
		} catch(NoResultException e) {
			;
		} catch(NonUniqueResultException e) {
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
		Member member0 = findById(member.getPk()); 
		member.setAverageAmount(member0.getAverageAmount());
		member.setExtra(member0.getExtra());
		member.setCreateTime(member0.getCreateTime());
		member.setCreateTime(member0.getCreateTime());
		member.setMemberGrade(member0.getMemberGrade());
		member.setMemberScore(member0.getMemberScore());
		member.setTotalAmount(member0.getTotalAmount());
		member.setTotalPoints(member0.getTotalPoints());
		entityManager.detach(member0);
		entityManager.merge(member);
	}
	
}
