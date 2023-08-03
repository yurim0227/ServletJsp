package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	public UserDTO selectOne(Connection conn, String userNo) {
		UserDTO result = null;
		String query = "select * from tb_user where user_no=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new UserDTO(rs.getInt("user_no"),
						rs.getString("user_id"),
						rs.getString("user_name"),
						rs.getInt("user_age"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
}
