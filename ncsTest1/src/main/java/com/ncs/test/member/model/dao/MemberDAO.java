package com.ncs.test.member.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ncs.test.member.model.vo.Member;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public Member loginMember(Member member) throws Exception {
		return sqlSession.selectOne("member.loginMember", member);
	}
	
	public int joinMember(Member member) throws Exception{
		return sqlSession.insert("member.joinMember", member);
	}
	
	public List<Member> listMember() throws Exception{
		return sqlSession.selectList("member.listMember");
	}
	
	public int deleteMember(Member member) throws Exception{
		return sqlSession.delete("member.deleteMember", member);
	}
	
	public int updateMember(Member member) throws Exception{
		return sqlSession.update("member.updateMember", member);
	}
}
