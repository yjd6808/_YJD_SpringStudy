package com.javalec.spring_test_item_mybatis.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javalec.spring_test_item_mybatis.*;
import com.javalec.spring_test_item_mybatis.dao.ItemDao;
import com.javalec.spring_test_item_mybatis.util.*;

@Controller
public class ItemController {
	
//	ItemService service;
	
//	public JdbcTemplate template;
//	
//	@Autowired  // servlet-context.xml에 추가한 DBCP(template bean) 주입
//	public void setTemplate(JdbcTemplate template) {
//		this.template = template;
//		Constant.template = this.template;
//	}
	
	@Autowired
	private SqlSession sqlSession;
	
	

	
	@RequestMapping("/write")  
	public String writeView() {
		System.out.println("###@@@ writeView()");
		
		return "itemWrite";   
	}
		
	
	
	@RequestMapping("/writeResult")
	public String itemWrite(HttpServletRequest request, Model model) {
		System.out.println("###@@@ WriteReal ###@@@");
		
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		dao.write(request.getParameter("name")
				, Integer.parseInt(request.getParameter("price")) 
				, request.getParameter("description"));
		
		return "writeResult";
		
	}
	
	
	@RequestMapping("/content_view")
	public String content_view(Model model) {
		System.out.println("###@@@ content_view()");
		
		ItemDao dao = sqlSession.getMapper(ItemDao.class);
		model.addAttribute("list", dao.list());
		
		return "content_view";
	}
}
