package com.ncs.test.member.model.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ncs.test.member.model.service.MemberService;
import com.ncs.test.member.model.vo.Member;

@Controller
@RequestMapping()
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/login")
	public String loginPage() {
	    return "member/index";
	}
	
	@PostMapping("/login")
    public String memberLogin(Model model, Member member, HttpServletRequest request) {
        HttpSession session = request.getSession();
        try {
            Member loginMember = memberService.loginMember(member);
            if (loginMember == null) {
            	model.addAttribute("msg", "로그인 실패");
                return "error/errorPage";
            } else {
                session.setAttribute("loginMember", loginMember);
                return "redirect:/login";
            }
        } catch (Exception e) {
        	model.addAttribute("msg", "로그인 실패");
            return "error/errorPage";
        }
    }
	
	@GetMapping("/join")
	public String joinPage() {
	    return "member/index";
	}
	
	@PostMapping("/join")
    public String memberJoin(Model model, Member member) {
        try {
            int joinMember = memberService.joinMember(member);
            if (joinMember < 1) {
            	model.addAttribute("msg", "회원가입 실패");
                return "error/errorPage";
            } else {
                return "redirect:/join";
            }
        } catch (Exception e) {
        	model.addAttribute("msg", "회원가입 실패");
            return "error/errorPage";
        }
    }
	
	@GetMapping("/list")
	public String memberList(Model model) throws Exception {
		model.addAttribute("listMember", memberService.listMember());
		return "member/index";
	}
	
	@PostMapping("/list")
	public String memberList(Model model, Member member) throws Exception {
		int deleteMember = memberService.deleteMember(member);
		try {
			if(deleteMember < 1) {
				model.addAttribute("msg", "회원탈퇴 실패");
				return "error/errorPage";
			} else {
				return "redirect:/list";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원탈퇴 실패");
			return "error/errorPage";
		}
	}
	
	@GetMapping("/update")
	public String memberUpdate() throws Exception {
		return "member/index";
	}
	
	@PostMapping("/update")
	public String memberUpdate(Model model, Member member) throws Exception {
		int updateMember = memberService.updateMember(member);
		try {
			if(updateMember < 1) {
				model.addAttribute("msg", "회원정보 수정 실패");
				return "error/errorPage";
			} else {
				return "redirect:/update";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원정보 수정 실패");
			return "error/errorPage";
		}
	}
}
