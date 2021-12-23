package com.jdyun.example13_mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("redirect")
public class RedirectController {

	@RequestMapping("confirm")
	public String redirectConfirm(HttpServletRequest req) {
		String id = req.getParameter("id");
		
		if (id.equals("target-a"))
			return "redirect:target-a";
		else if (id.equals("target-b"))
			return "redirect:target-b";
		
		return "redirect:else";
	}
	
	@RequestMapping("target-a")
	public String targetA() {
		return "redirect/target-a";
	}
	
	@RequestMapping("target-b")
	public String targetB() {
		return "redirect/target-b";
	}
	
	@RequestMapping("else")
	public String targetElse() {
		return "redirect/else";
	}
}
