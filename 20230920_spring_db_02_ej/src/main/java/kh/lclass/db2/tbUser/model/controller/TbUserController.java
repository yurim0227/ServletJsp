package kh.lclass.db2.tbUser.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.lclass.db2.tbUser.model.dto.TbUserDto;
import kh.lclass.db2.tbUser.model.service.TbUserServiceImpl;

@Controller
@RequestMapping("/user")
public class TbUserController {
	@Autowired
	private TbUserServiceImpl tbUserService;
	
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		mv.addObject("userList", tbUserService.selectList());
		mv.setViewName("user/list");
		return mv;
	}
	
	@GetMapping("/insert")
	public String insert() {
		String viewPage = "user/insert";
		return viewPage;
	}
	
	@PostMapping("/insert")
	public String insert(RedirectAttributes redirectAttr, @ModelAttribute("tbUserDto") TbUserDto tbUserDto) throws Exception {
		String viewPage;
		int result;
		try {
			result = tbUserService.insert(tbUserDto);
			if(result < 1) {
				redirectAttr.addFlashAttribute("msg", "실패했습니다. 다시 입력하고 등록해주세요.");
				viewPage = "redirect:/user/insert";
			} else {
				redirectAttr.addFlashAttribute("msg", "성공했습니다.");
				viewPage = "redirect:/user/list";
			}
		} catch (Exception e) {
			redirectAttr.addFlashAttribute("msg", "예기치 못한 상황으로 실패했습니다. 다시 시도해주세요.");
			viewPage = "redirect:/user/insert";
		}  
		return viewPage;
	}
	
	@GetMapping("/get")
	public ModelAndView get(ModelAndView mv, @RequestParam String userId) throws Exception {
		mv.addObject("userGet", tbUserService.selectOne(userId));
		mv.setViewName("user/get");
		return mv;
	}
}
