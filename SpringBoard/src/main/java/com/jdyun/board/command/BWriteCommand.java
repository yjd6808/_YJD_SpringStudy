package com.jdyun.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jdyun.board.dao.BDao;

public class BWriteCommand implements BCommand {
	// model을 map으로 변경하고, 펼쳐진 맵에서 request를 들고온것을  'request'로 받습니다.
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();    // asMap() : Map상태로 푼다.
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
		
	}
}
