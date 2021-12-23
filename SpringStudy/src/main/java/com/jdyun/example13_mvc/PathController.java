package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PathController {
	
	@RequestMapping("/board/path/{studentId}")
	public String path(@PathVariable String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "board/path";
	}
}
