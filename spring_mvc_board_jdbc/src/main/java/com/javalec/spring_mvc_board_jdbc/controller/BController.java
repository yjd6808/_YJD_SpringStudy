package com.javalec.spring_mvc_board_jdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import com.javalec.spring_mvc_board.command.BCommand;
//import com.javalec.spring_mvc_board.command.BContentCommand;
//import com.javalec.spring_mvc_board.command.BDeleteCommand;
//import com.javalec.spring_mvc_board.command.BListCommand;
//import com.javalec.spring_mvc_board.command.BModifyCommand;
//import com.javalec.spring_mvc_board.command.BWriteCommand;
import com.javalec.spring_mvc_board_jdbc.service.*;
import com.javalec.spring_mvc_board_jdbc.util.Constant;


@Controller
public class BController {  // ��Ʈ�ѷ����� Ŀ�ǵ�� �����غ���.
	
//	BCommand command; 
	BService service;
	
	public JdbcTemplate template;

	@Autowired  // 
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/list")
	public String list(Model model) {
		System.out.println("###@@@ list()");
//		command = new BListCommand();
//		command.execute(model);
		service = new BListService(); 
		service.execute(model);
		
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
		
		model.addAttribute("request", request); 
//		command = new BWriteCommand(); 
//		command.execute(model);
		service = new BWriteService(); 
		service.execute(model);   
		
		return "redirect:list";  
		
	}
	
	
	@RequestMapping("content_view")
	public String content_view(HttpServletRequest request, Model model) { // Ŀ�ǵ� �ܿ��� ���� �޾� �ѱ�� ���ؼ� model ��ü
	System.out.println("###@@@ content_view()");
	
	model.addAttribute("request", request);
//	command = new BContentCommand();
//	command.execute(model);
	service = new BContentService();
	service.execute(model);
	
	return "content_view";
	}
	
	
	@RequestMapping(value = "/modify")
	public String modify(HttpServletRequest request, Model model) {
		System.out.println("###@@@ modify()");
		
		
		model.addAttribute("request", request);
//		command = new BModifyCommand();
//		command.execute(model);
		service = new BModifyService();
		service.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		System.out.println("###@@@ delete()");
		
		
		model.addAttribute("request", request);
//		command = new BDeleteCommand();
//		command.execute(model);
		service = new BDeleteService();
		service.execute(model);
		
		return "redirect:list";
	}
	
	
	
	
	
	
	
	
}
