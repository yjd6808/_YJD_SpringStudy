package com.jdyun.board.command;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jdyun.board.dao.BDao;
import com.jdyun.board.dto.BDto;

public class BModifyCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter( "bId");
		String bName = request.getParameter( "bName");
		String bTitle = request.getParameter( "bTitle");
		String bContent = request.getParameter( "bContent");
		
		BDao dao = new BDao();
		int result = dao.modify(bId, bName, bTitle, bContent);
		model.addAttribute("modify_result", result);
		
		
	}
}
