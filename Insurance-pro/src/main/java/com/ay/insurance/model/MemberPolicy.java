package com.ay.insurance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "MemberPolicies")
public class MemberPolicy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long memberPolicyId;

	@ManyToOne
	@JoinColumn(name = "memberId")
	private Member member;

	@ManyToOne
	@JoinColumn(name = "policyId")
	private Policy policy;

	private String policyStatus;

	public Long getMemberPolicyId() {
		return memberPolicyId;
	}

	public void setMemberPolicyId(Long memberPolicyId) {
		this.memberPolicyId = memberPolicyId;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public String getPolicyStatus() {
		return policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		this.policyStatus = policyStatus;
	}

	public MemberPolicy(Long memberPolicyId, Member member, Policy policy, String policyStatus) {
		super();
		this.memberPolicyId = memberPolicyId;
		this.member = member;
		this.policy = policy;
		this.policyStatus = policyStatus;
	}

	public MemberPolicy() {
		super();
	}

}
