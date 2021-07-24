package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Member;

public interface MemberService {

	List<Member> findAll();

	Member findByMemberId(String memberId);

	void save(Member member);

	Member findById(Integer id);

	void update(Member member);

}