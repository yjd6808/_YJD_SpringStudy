package com.javalec.spring_test_item_mybatis_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.javalec.spring_test_item_mybatis_std.dto.ItemDto;

public interface ItemService {
	ArrayList<ItemDto> list();
	void write(HashMap<String, String> param);
}
