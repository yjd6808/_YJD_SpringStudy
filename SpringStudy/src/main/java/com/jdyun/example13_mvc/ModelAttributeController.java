package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class ModelAttributeController {
	
	@RequestMapping("model/form")
	public String indexView() {
		return "model/form";
	}
	
	
	
	
	@RequestMapping("model/attribute1")
	public String modelAttribute(ModelAttributeClass modelAttributeClass, Model model) {
		return "model/attribute1";
	}
	
	@RequestMapping("model/attribute2")
	public String modelAttribute(@ModelAttribute("studentInfo") ModelAttributeClass modelAttributeClass) {
		return "model/attribute2";
	}
}
