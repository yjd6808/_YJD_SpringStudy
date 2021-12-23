package com.jdyun.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdyun.board.command.BCommand;
import com.jdyun.board.command.BContentCommand;
import com.jdyun.board.command.BDeleteCommand;
import com.jdyun.board.command.BListCommand;
import com.jdyun.board.command.BModifyCommand;
import com.jdyun.board.command.BWriteCommand;

@Controller
public class BController {  // 컨트롤러에서 커맨드단 연결해보자.
	
	BCommand command;   // 전역변수 정의해보자.
	
	
	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("###@@@ list()");
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	
	
	@RequestMapping("/write_view")
	public String write_view() {
		System.out.println("@@@### write_view()");
		return "write_view";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) { // 자동으로 만들어준다. 
		System.out.println("@@@### write()");
		
		model.addAttribute("request", request);   // model 내부에 map 객체가 있다. 
		command = new BWriteCommand(); // 업캐스팅
		command.execute(model);   // model객체를 타고 writeCommand로 이동한다.
		
		return "redirect:list";  // 위에 있는 list메소드를 찾아간다.
		
	}
	
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) { // 커맨드 단에서 값을 받아 넘기기 위해서 model 객체
		System.out.println("###@@@ content_view()");
		
		model.addAttribute("request", request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("###@@@ modify()");
		
		model.addAttribute("request", request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("###@@@ delete()");
		
		model.addAttribute("request", request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
}
