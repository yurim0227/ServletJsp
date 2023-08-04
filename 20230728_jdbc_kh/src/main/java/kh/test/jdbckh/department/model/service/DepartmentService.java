package kh.test.jdbckh.department.model.service;

import java.sql.Connection;
import java.util.List;

import static kh.test.jdbckh.common.jdbc.JdbcTemplate.*;

import kh.test.jdbckh.department.model.dao.DepartmentDao;
import kh.test.jdbckh.department.model.dto.DepartmentDto;

public class DepartmentService {
	private DepartmentDao dao = new DepartmentDao();
	public List<DepartmentDto> selectList() {
		List<DepartmentDto> result = null;
		Connection conn = getConnection();
		result = dao.selectList(conn);
		close(conn);
		return result;
	}
	public DepartmentDto selectOne(String departmentNo) {
		DepartmentDto result = null;
		Connection conn = getConnection();
		result = dao.selectOne(conn, departmentNo);
		close(conn);
		return result;
	}
}
