package edu.kh.test.user.common.jdbc;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.kh.test.user.model.service.UserService;
import edu.kh.test.user.model.vo.UserDTO;

/**
 * Servlet implementation class InsertDoUserServlet
 */
@WebServlet("/insert.do2")
public class InsertDoUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertDoUserServlet() {
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
		String userId = request.getParameter("userId");
		String userName = request.getParameter("userName");
		String userAgeStr = request.getParameter("userAge");
		int userAge = Integer.parseInt(userAgeStr);
		UserDTO dto = new UserDTO(userId, userName, userAge);
		UserService service = new UserService();
		int result = service.insert(dto);
		response.sendRedirect(request.getContextPath()+"/");
	}

}
