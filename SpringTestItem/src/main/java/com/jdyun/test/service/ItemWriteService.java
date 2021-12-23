package com.jdyun.test.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.jdyun.test.dao.ItemDAO;

public class ItemWriteService implements ItemService {

	@Override
	public void service(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String name = request.getParameter( "name");
		String price = request.getParameter( "price");
		String description = request.getParameter( "description");
		new ItemDAO().write(name, price, description);
	}
	
}
