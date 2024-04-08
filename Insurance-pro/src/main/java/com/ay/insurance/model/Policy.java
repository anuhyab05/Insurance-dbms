package com.ay.insurance.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Policies")
public class Policy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	private String policyName;
	private String policyType;
	private BigDecimal monthlyPremium;

	public Long getPolicyId() {
		return policyId;
	}

	public void setPolicyId(Long policyId) {
		this.policyId = policyId;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public BigDecimal getMonthlyPremium() {
		return monthlyPremium;
	}

	public void setMonthlyPremium(BigDecimal monthlyPremium) {
		this.monthlyPremium = monthlyPremium;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public Policy() {
		super();
	}

	public Policy(Long policyId, String policyName, String policyType, BigDecimal monthlyPremium) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.policyType = policyType;
		this.monthlyPremium = monthlyPremium;
	}


}
