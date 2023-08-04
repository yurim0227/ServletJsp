package edu.kh.test.user.model.service;

import java.sql.Connection;
import java.util.List;

import static edu.kh.test.user.common.jdbc.JdbcTemplate.*;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

public class UserService {
	private UserDAO dao = new UserDAO();
	public List<UserDTO> selectList(){
		List<UserDTO> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	public UserDTO selectOne(String userNo) {
		UserDTO result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, userNo);
		close(conn);
		return result;
	}
	public int insert(UserDTO dto) {
		int result = 0;
		Connection conn = getConnection();
		result = dao.insert(conn, dto);
		close(conn);
		return result;
	}
}
