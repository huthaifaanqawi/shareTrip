package edu.mum.shareTrip.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.shareTrip.domain.Member;
import edu.mum.shareTrip.repository.MemberRepository;
import edu.mum.shareTrip.service.MemberService;

@Transactional
@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberRepository memberRepository;
	
	@Override
	public Member saveMember(Member member) {
		return memberRepository.save(member);
	}

}
