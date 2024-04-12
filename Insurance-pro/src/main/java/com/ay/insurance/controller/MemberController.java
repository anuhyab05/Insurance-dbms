package com.ay.insurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.ay.insurance.model.Member;
import com.ay.insurance.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping
	public String listMembers(Model model) {
		model.addAttribute("members", memberService.getAllMembers());
		return "members";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("member", new Member());
		return "add-member";
	}

	@PostMapping
	public String addMember(@ModelAttribute Member member) {
		memberService.saveMember(member);
		return "redirect:/members";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Member member = memberService.getMemberById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid member Id:" + id));
		model.addAttribute("member", member);
		return "update-member";
	}

	@PostMapping("/update/{id}")
	public String updateMember(@PathVariable("id") long id, @ModelAttribute Member member, Model model) {
		member.setMemberId(id);
		memberService.saveMember(member);
		return "redirect:/members";
	}

	@GetMapping("/delete/{id}")
	public String deleteMember(@PathVariable("id") long id, Model model) {
		memberService.deleteMember(id);
		return "redirect:/members";
	}
}
