package com.javalec.spring_mvc_board_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

//import com.javalec.spring_mvc_board.dao.BDao;
//import com.javalec.spring_mvc_board.dto.BDto;
import com.javalec.spring_mvc_board_jdbc.dao.*;
import com.javalec.spring_mvc_board_jdbc.dto.*;

public class BContentService implements BService{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter( "bId");    // content_view?${dto.bId}로 넘긴값을 받는것임.
		
		BDao dao = new BDao();
		BDto dto = dao.contentView(bId);
		model.addAttribute("content_view", dto);
	}

}
