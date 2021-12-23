package com.javalec.spring_test_member_jdbc.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_test_member_jdbc.dao.MemDao;

public class MemWriteService implements MemService {

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String memUid = request.getParameter("memUid");
		String memPwd = request.getParameter("memPwd");
		String memName = request.getParameter("memName");
		
		MemDao dao = new MemDao();
		dao.write(memUid, memPwd, memName);
		
		
		return 0;
	}
	

}
