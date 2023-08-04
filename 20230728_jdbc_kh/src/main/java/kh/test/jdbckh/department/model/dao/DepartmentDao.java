package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.close;

import kh.test.jdbckh.department.model.dto.DepartmentDto;
 
public class DepartmentDao {
	public List<DepartmentDto> selectList(Connection conn) {
		List<DepartmentDto> result = null;
		String query = "select * from tb_department";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(query);
			rs = pstmt.executeQuery();
			result = new ArrayList<DepartmentDto>();
			while(rs.next() == true) {
				DepartmentDto dto = new DepartmentDto();
				dto.setDepartmentNo(rs.getInt("department_no"));
				dto.setDepartmentName(rs.getString("department_name"));
				dto.setCategory(rs.getString("category"));
				dto.setOpenYn(rs.getString("open_yn"));
				dto.setCapacity(rs.getString("capacity"));
				
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
