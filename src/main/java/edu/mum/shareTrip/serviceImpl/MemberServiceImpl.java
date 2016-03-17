package edu.mum.shareTrip.serviceImpl;

import java.util.Date;
import java.util.List;

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

	@Override
	public Member getMemberByUserName(String username) {
		return memberRepository.getMemberByUserName(username);
	}

	@Override
	public List<Member> getMemberAvailabilityTrip(long id, Date mindate, Date maxdate, long tripid) {
		return memberRepository.getMemberAvailabilityTrip(id, mindate, maxdate, tripid);
	}

	@Override
	public List<Member> getMemberAvailabilityBook(long id, Date mindate, Date maxdate) {
		return memberRepository.getMemberAvailabilityBook(id, mindate, maxdate);
	}

}
