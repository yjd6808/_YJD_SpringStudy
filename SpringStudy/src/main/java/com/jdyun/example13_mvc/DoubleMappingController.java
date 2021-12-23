package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/new")
public class DoubleMappingController {
	
	@RequestMapping("/view")
	public String newview(Model model) {
		model.addAttribute("id", "Á¤µµ");
		return "new/view";
	}
}
