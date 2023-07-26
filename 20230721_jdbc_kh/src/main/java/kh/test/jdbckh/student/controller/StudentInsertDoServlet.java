package kh.test.jdbckh.student.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInsertDoServlet
 */
@WebServlet("/student/insert.do")
public class StudentInsertDoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentInsertDoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
// doGet() 메소드 삭제
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentNo = request.getParameter("studentNo");
		String departmentNo = request.getParameter("departmentNo");
		String studentName = request.getParameter("studentName");
		String studentSsn = request.getParameter("studentSsn");
		String studentAddress = request.getParameter("studentAddress");
		//오류 Date entranceDate = request.getParameter("entranceDate");
		String entranceDateStr = request.getParameter("entranceDate");
		String absenceYn = request.getParameter("absenceYn");
		String coachProfessorNo = request.getParameter("coachProfessorNo");
		
		
	}

}
