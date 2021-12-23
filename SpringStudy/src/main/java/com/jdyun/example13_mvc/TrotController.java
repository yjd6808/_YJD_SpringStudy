package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/trot")
public class TrotController {
	
	@RequestMapping("/student")
	public String student(Model model) {
		model.addAttribute("id", "jungdo");
		return "trot/student";
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("id", "jjfirjfosedrjf");
		mv.setViewName("trot/admin");
		return mv;
	}
}
