package com.jdyun.example13_mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {

//	@RequestMapping("/board/join")
//	public String joinData( @RequestParam("name") String name
//			              , @RequestParam("id") String id
//			              , @RequestParam("pw") String pw
//			              , @RequestParam("email") String email
//			              , Model model) {
//		
//		Member member = new Member();
//		member.setId(id);
//		member.setEmail(email);
//		member.setPw(pw);
//		member.setName(name);
//		model.addAttribute("member", member);
//		return "board/join";
//	}
	
	@RequestMapping("/board/join")
	public String joinData( Member member, Model model) {
		model.addAttribute("member", member);
		return "board/join";
	}
}
