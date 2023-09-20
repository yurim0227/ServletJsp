package kh.lclass.db3.tbUser.model.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kh.lclass.db3.tbUser.model.dto.TbUserDto;
import kh.lclass.db3.tbUser.model.service.TbUserService;

@Controller
@RequestMapping("/user")
public class TbUserController {
	@Autowired
	private TbUserService tbUserService;
	
	@GetMapping("/list")
	public ModelAndView list(ModelAndView mv) throws Exception {
		mv.addObject("userList", tbUserService.selectList());
		mv.setViewName("user/list");
		return mv;
	}
	
	@GetMapping("/insert")
	public ModelAndView insert(ModelAndView mv) throws Exception {
		mv.setViewName("user/insert");
		return mv;
	}
	
	@PostMapping("/insert")
	public ModelAndView insert(RedirectAttributes redirectAttr, ModelAndView mv, TbUserDto tbUserDto) throws Exception {
		int result;
		try {
			result = tbUserService.insert(tbUserDto);
			if(result < 1) {
				redirectAttr.addFlashAttribute("msg", "실패");
				mv.setViewName("redirect:/user/insert");
			} else {
				redirectAttr.addFlashAttribute("msg", "성공");
				mv.setViewName("redirect:/user/list");
			}
		} catch (Exception e) {
			redirectAttr.addFlashAttribute("msg", "실패");
			mv.setViewName("redirect:/user/insert");
		}
		return mv;
	}
	
	@GetMapping("/get")
	public ModelAndView get(ModelAndView mv, String userId) throws Exception {
		mv.addObject("userGet", tbUserService.selectOne(userId));
		mv.setViewName("user/get");
		return mv;
	}
}
