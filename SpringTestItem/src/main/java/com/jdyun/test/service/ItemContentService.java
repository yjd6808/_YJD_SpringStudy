package com.jdyun.test.service;


import org.springframework.ui.Model;

import com.jdyun.test.dao.ItemDAO;

public class ItemContentService implements ItemService {

	@Override
	public void service(Model model) {
		model.addAttribute("list", new ItemDAO().list());
	}
	
}
