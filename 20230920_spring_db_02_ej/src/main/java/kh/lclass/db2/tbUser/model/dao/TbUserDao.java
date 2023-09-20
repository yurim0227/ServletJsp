package kh.lclass.db2.tbUser.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kh.lclass.db2.tbUser.model.dto.TbUserDto;

@Repository
public class TbUserDao {
	@Autowired
	private SqlSession sqlSession;
	
	public List<TbUserDto> selectList() throws Exception {
		return sqlSession.selectList("user.selectList");
	}
	
	public int insert(TbUserDto tbUserDto) throws Exception {
		return sqlSession.insert("user.insert", tbUserDto);
	}
	
	public TbUserDto selectOne(String userId) throws Exception {
		return sqlSession.selectOne("user.selectOne", userId);
	}
}
