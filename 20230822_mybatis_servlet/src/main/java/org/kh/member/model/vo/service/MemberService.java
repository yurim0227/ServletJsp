package org.kh.member.model.vo.service;

import org.apache.ibatis.session.SqlSession;
import org.kh.comm.SqlSessionTemplate;
import org.kh.member.model.dao.MemberDAO;
import org.kh.member.model.vo.MemberVO.MemberVO;

public class MemberService {
	MemberDAO memberDAO = new MemberDAO();
	public int insertMember(MemberVO mOne) {
		SqlSession session = SqlSessionTemplate.getSqlSession();
		int result = memberDAO.insertMember(session, mOne);
		if(result>0) {
			session.commit();
		} else {
			session.rollback();
		}
		session.close();
		return result;
	}
}
