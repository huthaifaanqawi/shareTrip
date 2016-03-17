package edu.mum.shareTrip.service;

import java.util.Date;
import java.util.List;

import edu.mum.shareTrip.domain.Member;

public interface MemberService {

	public Member saveMember(Member member);
	
	public Member getMemberByUserName(String username);
	
	public List<Member> getMemberAvailabilityTrip(long id, Date mindate, Date maxdate, long tripid);
	
	public List<Member> getMemberAvailabilityBook(long id, Date mindate, Date maxdate);
	
}
