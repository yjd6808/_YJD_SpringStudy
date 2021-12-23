package com.javalec.spring_test_item_mybatis_std.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javalec.spring_test_item_mybatis_std.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println("call list()");
		model.addAttribute("list", itemService.list());
		return "list";
	}
	
	@RequestMapping("write")
	public String write() {
		System.out.println("call write()");
		return "write";
	}
	
	@RequestMapping("writeItem")
	public String writeItem(@RequestParam HashMap<String, String> param) {
		System.out.println("call writeItem(" + param.size() + ")");
		itemService.write(param);
		return "redirect:list";
	}
	
}
