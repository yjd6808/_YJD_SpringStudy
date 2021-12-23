package com.jdyun.example13_mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {
	
	@RequestMapping("/index")
	public String goStudent() {
		return "student/student";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public String goStudent(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		model.addAttribute("studentId", "POST : " + id);
		return "student/studentId";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/student")
	public String goStudent(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView();
		String id = request.getParameter("id");
		modelAndView.addObject("studentId", "GET : " + id);
		return "student/studentId";
	}
}
