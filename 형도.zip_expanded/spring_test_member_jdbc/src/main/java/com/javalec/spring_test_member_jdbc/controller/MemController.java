package com.javalec.spring_test_member_jdbc.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_test_member_jdbc.dao.IMemDao;
import com.javalec.spring_test_member_jdbc.service.*;
import com.javalec.spring_test_member_jdbc.util.Constant;



@Controller
public class MemController {
	MemService command;
	JdbcTemplate template;
	public SqlSession sqlSession;
	
	@Autowired
	public void setSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
		Constant.sqlSession = sqlSession;
	}
	
	
	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

	@RequestMapping("/login")
	public String login() {
		System.out.println("###@@@ login");
		
		return "login";
	}
	
	@RequestMapping("/login_yn")
	public String login_ok(HttpServletRequest request, Model model) {
		System.out.println("###@@@ login_yn");
		
		IMemDao dao = sqlSession.getMapper(IMemDao.class);
		model.addAttribute("request", request); // 서비스 호출 -> 결과값 -1 0 1
		command = new MemLoginService();
		int result = command.execute(model);    
		
		if (result == 1) {
			return "redirect:login_ok";
		}
		return "redirect:login";
	}
	
	@RequestMapping("/login_ok")
	public String login_ok() {
		System.out.println("###@@@ login_ok");
		
		
		return "login_ok";
	}
	
	@RequestMapping("/register")
	public String register() {
		System.out.println("###@@@ register");
		
		
		return "register";
	}
	
	@RequestMapping("/registerOk")
	public String registerOk(HttpServletRequest request, Model model) {
		System.out.println("###@@@ registerOk");
		
		model.addAttribute("request", request);
		command = new MemWriteService();
		command.execute(model);
		
		return "redirect:login";
	}

}
