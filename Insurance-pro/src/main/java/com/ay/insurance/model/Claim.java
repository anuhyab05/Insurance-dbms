package com.ay.insurance.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Claims")
public class Claim {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long claimId;

	@ManyToOne
	@JoinColumn(name = "memberPolicyId")
	private MemberPolicy memberPolicy;

	private BigDecimal claimAmount;
	private String claimStatus;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public MemberPolicy getMemberPolicy() {
		return memberPolicy;
	}

	public void setMemberPolicy(MemberPolicy memberPolicy) {
		this.memberPolicy = memberPolicy;
	}

	public BigDecimal getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(BigDecimal claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public Claim(Long claimId, MemberPolicy memberPolicy, BigDecimal claimAmount, String claimStatus) {
		super();
		this.claimId = claimId;
		this.memberPolicy = memberPolicy;
		this.claimAmount = claimAmount;
		this.claimStatus = claimStatus;
	}

	public Claim() {
		super();
	}

}
