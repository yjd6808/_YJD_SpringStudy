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
public class BController {  // ��Ʈ�ѷ����� Ŀ�ǵ�� �����غ���.
	
	BCommand command;   // �������� �����غ���.
	
	
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
	public String write(HttpServletRequest request, Model model) { // �ڵ����� ������ش�. 
		System.out.println("@@@### write()");
		
		model.addAttribute("request", request);   // model ���ο� map ��ü�� �ִ�. 
		command = new BWriteCommand(); // ��ĳ����
		command.execute(model);   // model��ü�� Ÿ�� writeCommand�� �̵��Ѵ�.
		
		return "redirect:list";  // ���� �ִ� list�޼ҵ带 ã�ư���.
		
	}
	
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) { // Ŀ�ǵ� �ܿ��� ���� �޾� �ѱ�� ���ؼ� model ��ü
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
