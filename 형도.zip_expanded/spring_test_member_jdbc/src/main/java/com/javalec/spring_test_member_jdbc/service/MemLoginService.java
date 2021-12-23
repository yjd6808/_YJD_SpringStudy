package com.javalec.spring_test_member_jdbc.service;

import java.util.ArrayList;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.javalec.spring_test_member_jdbc.dao.*;
import com.javalec.spring_test_member_jdbc.dto.MemDto;
import com.javalec.spring_test_member_jdbc.util.Constant;

public class MemLoginService implements MemService {

	@Override
	public int execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String memUid = request.getParameter("memUid");
		String memPwd = request.getParameter("memPwd");
		
		
		int re = 0;
		IMemDao dao = Constant.sqlSession.getMapper(IMemDao.class);
		ArrayList<MemDto> pws = dao.loginYn(memUid);
		
		if (pws.isEmpty()) {
			re = -1;
		} else {
			if (memPwd.equals(pws.get(0).getMemPwd())) {
				re = 1;
			} else {
				re = 0;
			}
		}
		
		return re;
		 
		}
		
		
	}


