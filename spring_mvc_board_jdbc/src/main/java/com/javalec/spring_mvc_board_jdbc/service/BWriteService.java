package com.javalec.spring_mvc_board_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

//import com.javalec.spring_mvc_board.dao.BDao;
import com.javalec.spring_mvc_board_jdbc.dao.*;

public class BWriteService implements BService{
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();    
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
	}
}
