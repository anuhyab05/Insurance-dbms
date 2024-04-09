package com.ay.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ay.insurance.model.Member;
import com.ay.insurance.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/members")
	public String listMembers(Model model) {
		model.addAttribute("members", memberService.getAllMembers());
		return "members"; // points to src/main/resources/templates/members.html
	}

	@PostMapping("/members")
	public String addMember(Member member) {
		memberService.saveMember(member);
		return "redirect:/members";
	}
}
