package com.ay.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.insurance.model.Claim;
import com.ay.insurance.repository.ClaimRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimService {

	private final ClaimRepository claimRepository;

	@Autowired
	public ClaimService(ClaimRepository claimRepository) {
		this.claimRepository = claimRepository;
	}

	public Claim saveClaim(Claim claim) {
		return claimRepository.save(claim);
	}

	public Optional<Claim> getClaimById(Long id) {
		return claimRepository.findById(id);
	}

	public List<Claim> getAllClaims() {
		return claimRepository.findAll();
	}

	public void deleteClaim(Long id) {
		claimRepository.deleteById(id);
	}
}
