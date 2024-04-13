package com.ay.insurance.controller;

import com.ay.insurance.model.Claim;
import com.ay.insurance.service.ClaimService;
import com.ay.insurance.service.MemberPolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;
    private final MemberPolicyService memberPolicyService;

    @Autowired
    public ClaimController(ClaimService claimService, MemberPolicyService memberPolicyService) {
        this.claimService = claimService;
        this.memberPolicyService = memberPolicyService;
    }

    @GetMapping
    public String listClaims(Model model) {
        model.addAttribute("claims", claimService.getAllClaims());
        return "claims";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("claim", new Claim());
        model.addAttribute("memberPolicies", memberPolicyService.getAllMemberPolicies());
        return "add-claim";
    }

    @PostMapping
    public String addClaim(@ModelAttribute Claim claim) {
        claimService.saveClaim(claim);
        return "redirect:/claims";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Claim claim = claimService.getClaimById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid claim Id:" + id));
        model.addAttribute("claim", claim);
        model.addAttribute("memberPolicies", memberPolicyService.getAllMemberPolicies());
        return "update-claim";
    }

    @PostMapping("/update/{id}")
    public String updateClaim(@PathVariable("id") long id, @ModelAttribute Claim claim) {
        claim.setClaimId(id);
        claimService.saveClaim(claim);
        return "redirect:/claims";
    }

    @GetMapping("/delete/{id}")
    public String deleteClaim(@PathVariable("id") long id) {
        claimService.deleteClaim(id);
        return "redirect:/claims";
    }
}
