package kh.test.jdbckh.department.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kh.test.jdbckh.department.model.dto.DepartmentDto;
import kh.test.jdbckh.department.model.service.DepartmentService;

/**
 * Servlet implementation class DepartmentInsertDoController
 */
@WebServlet("/insert.do")
public class DepartmentInsertDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentInsertDoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String departmentNoStr = request.getParameter("departmentNo");
		int departmentNo = Integer.parseInt(departmentNoStr);
		String departmentName = request.getParameter("departmentName");
		String category = request.getParameter("category");
		String openYn = request.getParameter("openYn");
		String capacity = request.getParameter("capacity");
		DepartmentDto dto = new DepartmentDto(departmentNo, departmentName, category, openYn, capacity);
		DepartmentService service = new DepartmentService();
		int result = service.insert(dto);
		response.sendRedirect(request.getContextPath()+"/dept/list");
	}

}
