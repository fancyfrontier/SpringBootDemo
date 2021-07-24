package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/springmvc/members")
	public String getMemberSpringMvc(Model model) {
		List<Member> members = memberService.findAll();
		model.addAttribute("members123", members);
		return "smvc/showAllMembers";
	}
}
