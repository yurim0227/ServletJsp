package kh.spring.test1024.member.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kh.spring.test1024.member.dao.MemberDAO;

@Controller
public class CheckEmail {
	@Autowired
	private MemberDAO memberDAO;
	
	@ResponseBody
	@RequestMapping("/CheckEmail")
	public void checkEmail(HttpServletResponse response, HttpServletRequest request) {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter resp = null;
		
		// Q. 5. 클라이언트로 부터 넘어오는 email 값을 받고 MemberDAO 클래스의 isEmailExist 함수에 인자값으로 전송받은 email 을 전달한다.
//		String email = _______.____________("_____");
//		try {
//			resp = response.getWriter();
//			_______ result = memberDAO.isEmailExist(_____);
//	
//			if(result) {
//				// Q. 7. DAO 로 부터 반환받은 값이 true 라면 클라이언트에게 "이미 사용중인 email 입니다." 라고 클라이언트에게 반환한다.
//				resp._______("_____________");
//			}else {
//				// Q. 8. DAO 로 부터 반환받은 값이 false 라면 클라이언트에게 "사용 가능한 email 입니다." 라고 클라이언트에게 반환한다.
//				resp._______("_____________");
//			}
//		}catch(Exception e) {
//			e.printStackTrace();
//			// Q. 9. 만약 true 도 false 도 아닌 예외가 발생했다면, "조회하는 도중 오류가 발생했습니다." 라고 클라이언트에게 반환한다.
//			resp._______("_____________");
//		} finally {
//			if(resp != null) {
//				resp.flush();
//				resp.close();
//			}
//		}
		String email = request.getParameter("email");
		try {
			resp = response.getWriter();
			boolean result = memberDAO.isEmailExist(email);
	
			if(result) {
				resp.append("이미 사용중인 email 입니다.");
			}else {
				resp.append("사용 가능한 email 입니다.");
			}
		}catch(Exception e) {
			e.printStackTrace();
			resp.append("조회하는 도중 오류가 발생했습니다.");
		} finally {
			if(resp != null) {
				resp.flush();
				resp.close();
			}
		}
	}

}
