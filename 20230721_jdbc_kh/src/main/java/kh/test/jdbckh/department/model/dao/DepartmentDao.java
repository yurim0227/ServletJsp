package kh.test.jdbckh.department.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kh.test.jdbckh.department.model.vo.DepartmentVo;

public class DepartmentDao {
	public DepartmentVo selectOneDepartment(String departmentNo){
		DepartmentVo result = null;
		String query = "select * from tb_department where department_no = "+"'"+departmentNo+"'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe","kh","kh");
//			if(conn==null) {
//				System.out.println("연결실패");
//			}else {
//				System.out.println("연결 성공");
//			}
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result =new DepartmentVo();
				// while 동작시킬필요없음. query 결과가 단일행일 것이므로
				result.setDepartmentNo(rset.getString("Department_No"));
				result.setDepartmentName(rset.getString("Department_Name"));
				result.setCategory(rset.getString("Category"));
				result.setOpenYn(rset.getString("Open_Yn"));
				result.setCapacity(rset.getInt("Capacity"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}
	
	// DB에서 tb_student 테이블에 있는 모든 내용을 읽어서 꺼냄.
	public List<DepartmentVo> selectListDepartment() {
		List<DepartmentVo> result = null;
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try {
			// 1. driver 있다면 로딩함. // 없다면 ClassNotFoundException 오류 발생
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. Connection 객체 생성 // dbms와 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "kh", "kh");
			if(conn != null) {
				System.out.println("DB연결 성공!!!!!!!!!!");
			} else {
				System.out.println("------ DB 연결 실패------");
			}
			// 3. Statement/PrepareStatement 객체 생성 -conn 객체로부터 - query 문을 실어보냄
//			stmt = conn.createStatement();
			String query = "select * from tb_department";
			pstmt = conn.prepareStatement(query);
			// 4. query 문을 실행해달라고 함. 그 결과값을 return 받음.
			// select query 문이면 ResultSet 모양
			// insert/update/delete 문이면 int 모양
			ResultSet  rs = pstmt.executeQuery();
			
			// 5. ResultSet 에서 row(record)=한줄 읽어오기 위해 cursor(포인트)를 이동함.
			result = new ArrayList<DepartmentVo>();
			while(rs.next() == true) {
				// 한줄row/record 를 읽을 준비 완료
				// 확인용도. System.out.println( rs.getString("STUDENT_NAME") );
				// System.out.println( rs.getString("컬럼명") );
				DepartmentVo vo = new DepartmentVo();
				vo.setDepartmentNo( rs.getString("Department_No"));
				vo.setDepartmentName( rs.getString("Department_Name"));
				vo.setCategory( rs.getString("Category"));
				vo.setOpenYn( rs.getString("Open_Yn"));
				vo.setCapacity( rs.getInt("Capacity"));
				
				result.add(vo);
			}
		} catch (ClassNotFoundException e) {
			// 1. driver (ojdbc.jar) 없음
			e.printStackTrace();
		} catch (SQLException e) {
			// 2. dbms에 연결 실패
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(stmt!=null) {
					stmt.close();
				}
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		// 확인용 System.out.println(result);
		return result;
	}
}
