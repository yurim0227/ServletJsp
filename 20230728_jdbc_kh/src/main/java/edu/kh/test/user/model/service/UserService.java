package edu.kh.test.user.model.service;

import java.sql.Connection;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

import edu.kh.test.user.model.dao.UserDAO;
import edu.kh.test.user.model.vo.UserDTO;

public class UserService {
	private UserDAO dao = new UserDAO();
	public UserDTO selectOne(String userNo) {
		UserDTO result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, userNo);
		close(conn);
		return result;
	}
}
