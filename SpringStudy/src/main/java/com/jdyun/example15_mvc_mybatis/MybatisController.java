package com.jdyun.example15_mvc_mybatis;

import java.sql.Timestamp;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jdyun.example15_mvc_mybatis.dao.IDao;





@Controller
public class MybatisController {
	
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping("example15/list")
	public String list(Model model) {
		IDao dao = sqlSession.getMapper(IDao.class);
		model.addAttribute("list", dao.list());
		return "example15/list";
	}
}
