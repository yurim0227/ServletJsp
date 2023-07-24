package kh.test.jdbckh.department.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.dao.DepartmentDao;
import kh.test.jdbckh.department.model.vo.DepartmentVo;

/**
 * Servlet implementation class DepartmentGetController
 */
@WebServlet("/department/get")
public class DepartmentGetController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentGetController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전달받은 parameter 읽어내기
		String departmentNo = request.getParameter("sno");
		System.out.println(departmentNo);
		// 전달받은 데이터를 활용해 DB학생 상세 정보 가져오기
		DepartmentDao dao =new DepartmentDao();
		DepartmentVo vo = dao.selectOneDepartment(departmentNo);
		request.setAttribute("svo", vo);
		request.getRequestDispatcher("/WEB-INF/view/department/get.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}

}
