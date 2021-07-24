package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.Member;

public interface MemberRepository {

	List<Member> findAll();

	Member findByMemberId(String memberId);

	void save(Member member);

	Member findById(Integer id);

	void update(Member member);

}