package com.ay.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.insurance.model.Policy;
import com.ay.insurance.repository.PolicyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {

	private final PolicyRepository policyRepository;

	@Autowired
	public PolicyService(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
	}

	public Policy savePolicy(Policy policy) {
		return policyRepository.save(policy);
	}

	public Optional<Policy> getPolicyById(Long id) {
		return policyRepository.findById(id);
	}

	public List<Policy> getAllPolicies() {
		return policyRepository.findAll();
	}

	public void deletePolicy(Long id) {
		policyRepository.deleteById(id);
	}
}
