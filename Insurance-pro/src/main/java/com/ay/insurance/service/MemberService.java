package com.ay.insurance.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ay.insurance.model.Member;
import com.ay.insurance.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

	private final MemberRepository memberRepository;

	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

	public Optional<Member> getMemberById(Long id) {
		return memberRepository.findById(id);
	}

	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	public void deleteMember(Long id) {
		memberRepository.deleteById(id);
	}
}
