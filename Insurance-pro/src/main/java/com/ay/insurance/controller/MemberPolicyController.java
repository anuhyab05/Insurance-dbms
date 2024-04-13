package com.ay.insurance.controller;

import com.ay.insurance.model.MemberPolicy;
import com.ay.insurance.service.MemberPolicyService;
import com.ay.insurance.service.MemberService;
import com.ay.insurance.service.PolicyService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/memberpolicies")
public class MemberPolicyController {

	private final MemberPolicyService memberPolicyService;
	private final MemberService memberService;
	private final PolicyService policyService;

	@Autowired
	public MemberPolicyController(MemberPolicyService memberPolicyService, MemberService memberService,
			PolicyService policyService) {
		this.memberPolicyService = memberPolicyService;
		this.memberService = memberService;
		this.policyService = policyService;
	}

	@GetMapping
	public String listMemberPolicies(Model model) {
		model.addAttribute("memberPolicies", memberPolicyService.getAllMemberPolicies());
		return "memberpolicies";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("memberPolicy", new MemberPolicy());
		model.addAttribute("members", memberService.getAllMembers());
		model.addAttribute("policies", policyService.getAllPolicies());
		return "add-memberpolicy";
	}

//	@PostMapping
//	public String addMemberPolicy(@ModelAttribute MemberPolicy memberPolicy) {
//		memberPolicyService.saveMemberPolicy(memberPolicy);
//		return "redirect:/memberpolicies";
//	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		MemberPolicy memberPolicy = memberPolicyService.getMemberPolicyById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid memberPolicy Id:" + id));
		model.addAttribute("memberPolicy", memberPolicy);
		model.addAttribute("members", memberService.getAllMembers());
		model.addAttribute("policies", policyService.getAllPolicies());
		return "update-memberpolicy";
	}

	@PostMapping("/update/{id}")
	public String updateMemberPolicy(@PathVariable("id") long id, @ModelAttribute MemberPolicy memberPolicy) {
		memberPolicy.setMemberPolicyId(id);
		memberPolicyService.saveMemberPolicy(memberPolicy);
		return "redirect:/memberpolicies";
	}

	@GetMapping("/delete/{id}")
	public String deleteMemberPolicy(@PathVariable("id") long id) {
		memberPolicyService.deleteMemberPolicy(id);
		return "redirect:/memberpolicies";
	}

	@GetMapping("/search")
	public String searchPolicies(@RequestParam("memberId") Long memberId, Model model) {
		List<MemberPolicy> memberPolicies = memberPolicyService.findPoliciesByMemberId(memberId);
		model.addAttribute("memberPolicies", memberPolicies);
		return "memberpolicies";
	}

	@PostMapping
	public String addMemberPolicy(@ModelAttribute MemberPolicy memberPolicy, Model model) {
		if (memberPolicyService.isPolicyDuplicateForMember(memberPolicy.getMember().getMemberId(),
				memberPolicy.getPolicy().getPolicyId())) {
			model.addAttribute("errorMessage", "Duplicate policy for member.");
			model.addAttribute("members", memberService.getAllMembers());
			model.addAttribute("policies", policyService.getAllPolicies());
			return "add-memberpolicy";
		} else {
			memberPolicyService.saveMemberPolicy(memberPolicy);
			return "redirect:/memberpolicies";
		}
	}
}
