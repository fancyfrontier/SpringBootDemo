package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Member;
import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Service
@Transactional
public class MemberServiceImpl implements MemberService  {

	@Autowired
	MemberRepository  memberRepository;
	
	
	
	@Override
	public List<Member>  findAll(){
		return memberRepository.findAll();
	}

	@Override
	public Member findByMemberId(String memberId) {
		return memberRepository.findByMemberId(memberId);
	}

	@Override
	public void save(Member member) {
		if (findByMemberId(member.getId()) != null) {
			throw new RuntimeException("帳號已存在，請更換新帳號");
		}
		memberRepository.save(member);
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
