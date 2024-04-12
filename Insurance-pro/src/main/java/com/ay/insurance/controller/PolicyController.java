package com.ay.insurance.controller;

import com.ay.insurance.model.Policy;
import com.ay.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    @GetMapping
    public String listPolicies(Model model) {
        model.addAttribute("policies", policyService.getAllPolicies());
        return "policies";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("policy", new Policy());
        return "add-policy";
    }

    @PostMapping
    public String addPolicy(@ModelAttribute Policy policy) {
        policyService.savePolicy(policy);
        return "redirect:/policies";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Policy policy = policyService.getPolicyById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid policy Id:" + id));
        model.addAttribute("policy", policy);
        return "update-policy";
    }

    @PostMapping("/update/{id}")
    public String updatePolicy(@PathVariable("id") long id, @ModelAttribute Policy policy) {
        policy.setPolicyId(id);
        policyService.savePolicy(policy);
        return "redirect:/policies";
    }

    @GetMapping("/delete/{id}")
    public String deletePolicy(@PathVariable("id") long id) {
        policyService.deletePolicy(id);
        return "redirect:/policies";
    }
}
