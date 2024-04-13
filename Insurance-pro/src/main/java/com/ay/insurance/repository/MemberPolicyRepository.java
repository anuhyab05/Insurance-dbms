package com.ay.insurance.repository;

import com.ay.insurance.model.MemberPolicy;
import com.ay.insurance.model.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MemberPolicyRepository extends JpaRepository<MemberPolicy, Long> {
    List<MemberPolicy> findByMemberMemberId(Long memberId);
    Optional<MemberPolicy> findByMemberMemberIdAndPolicyPolicyId(Long memberId, Long policyId);
}
