package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;

import kh.test.jdbckh.department.model.dto.DepartmentDto;

public class DepartmentDao {
	public DepartmentDto selectOne(Connection conn, String departmentNo) {
		DepartmentDto result = null;
		String query = "select * from tb_department where department_no = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, departmentNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = new DepartmentDto(rs.getInt("department_No")
						,rs.getString("department_Name")
						,rs.getString("category")
						,rs.getString("open_Yn")
						,rs.getString("capacity")
						);
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
