package com.jdyun.board.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jdyun.board.dao.BDao;

public class BWriteCommand implements BCommand {
	// model�� map���� �����ϰ�, ������ �ʿ��� request�� ����°���  'request'�� �޽��ϴ�.
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();    // asMap() : Map���·� Ǭ��.
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		BDao dao = new BDao();
		dao.write(bName, bTitle, bContent);
		
	}
}