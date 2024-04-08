package com.ay.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ay.insurance.model.MemberPolicy;
@Repository
public interface MemberPolicyRepository extends JpaRepository<MemberPolicy, Long> {

}
