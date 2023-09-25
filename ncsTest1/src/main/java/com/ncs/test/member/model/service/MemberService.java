package com.ncs.test.member.model.service;

import java.util.List;

import com.ncs.test.member.model.vo.Member;

public interface MemberService {
	Member loginMember(Member member) throws Exception;
	
	int joinMember(Member member) throws Exception;
	
	List<Member> listMember() throws Exception;
	
	int deleteMember(Member member) throws Exception;
}
