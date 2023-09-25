package com.ncs.test.member.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ncs.test.member.model.dao.MemberDAO;
import com.ncs.test.member.model.vo.Member;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;
	
	@Override
	public Member loginMember(Member member) throws Exception {
		return memberDAO.loginMember(member);
	}
	
	@Override
	public int joinMember(Member member) throws Exception{
		return memberDAO.joinMember(member);
	}
	
	@Override
	public List<Member> listMember() throws Exception{
		return memberDAO.listMember();
	}
	
	@Override
	public int deleteMember(Member member) throws Exception{
		return memberDAO.deleteMember(member);
	}
}
