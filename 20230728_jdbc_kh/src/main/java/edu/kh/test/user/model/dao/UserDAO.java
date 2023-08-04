package edu.kh.test.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static edu.kh.test.user.common.jdbc.JdbcTemplate.close;

import edu.kh.test.user.model.vo.UserDTO;

public class UserDAO {
	public List<UserDTO> selectList(Connection conn){
		List<UserDTO> result = null;
		String query = "select * from tb_user";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<UserDTO>();
			while(rs.next() == true) {
				UserDTO dto = new UserDTO();
				dto.setUserNo(rs.getInt("user_no"));
				dto.setUserId(rs.getString("user_id"));
				dto.setUserName(rs.getString("user_name"));
				dto.setUserAge(rs.getInt("user_age"));
				result.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return result;
	}
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
	public int insert(Connection conn, UserDTO dto) {
		int result = 0;
		String query = "insert into tb_user values (seq_uno.nextval,?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dto.getUserId());
			pstmt.setString(2, dto.getUserName());
			pstmt.setString(3, String.valueOf(dto.getUserAge()));
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
