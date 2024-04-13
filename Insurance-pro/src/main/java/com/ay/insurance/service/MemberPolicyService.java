package com.ay.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.insurance.model.MemberPolicy;
import com.ay.insurance.repository.MemberPolicyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberPolicyService {

	private final MemberPolicyRepository memberPolicyRepository;

	@Autowired
	public MemberPolicyService(MemberPolicyRepository memberPolicyRepository) {
		this.memberPolicyRepository = memberPolicyRepository;
	}

	public MemberPolicy saveMemberPolicy(MemberPolicy memberPolicy) {
		return memberPolicyRepository.save(memberPolicy);
	}

	public Optional<MemberPolicy> getMemberPolicyById(Long id) {
		return memberPolicyRepository.findById(id);
	}

	public List<MemberPolicy> getAllMemberPolicies() {
		return memberPolicyRepository.findAll();
	}

	public void deleteMemberPolicy(Long id) {
		memberPolicyRepository.deleteById(id);
	}

	public List<MemberPolicy> findPoliciesByMemberId(Long memberId) {
		return memberPolicyRepository.findByMemberMemberId(memberId);
	}

	public boolean isPolicyDuplicateForMember(Long memberId, Long policyId) {
		return memberPolicyRepository.findByMemberMemberIdAndPolicyPolicyId(memberId, policyId).isPresent();
	}
}
