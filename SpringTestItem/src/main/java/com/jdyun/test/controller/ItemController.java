package com.jdyun.test.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdyun.test.service.ItemContentService;
import com.jdyun.test.service.ItemWriteService;

@Controller
public class ItemController {

	@RequestMapping("/list")
	public String list(Model model) {
		new ItemContentService().service(model);
		return "content_view";
	}
	
	@RequestMapping("/writeView")
	public String writeView() {
		return "itemWrite";
	}
	
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model)  {
		
		model.addAttribute("request", request);
		new ItemWriteService().service(model);
		
		return "writeResult";
	}
}
