package kh.spring.test1024.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public boolean isEmailExist(String email) throws Exception{
		// Q. 6. isEmailExist 함수는 전달받은 email이 member 테이블 내에 존재하는지 검사하고 그 결과를 boolean 형으로 반환한다.
//		___________  returnEmail = sqlSession.selectOne("member.checkEmail", email);
//		boolean result = false; 
//		if(______________________________) {
//			result = true;
//		}
		String returnEmail = sqlSession.selectOne("member.checkEmail", email);
		boolean result = false;
		if(returnEmail != null) {
			result = true;
		}
		
		return result;
	}
}
