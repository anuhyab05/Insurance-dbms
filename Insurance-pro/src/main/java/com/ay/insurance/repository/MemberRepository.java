package com.ay.insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ay.insurance.model.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

}
