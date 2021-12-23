package com.javalec.spring_test_item_mybatis_std.dao;

import java.util.ArrayList;

import com.javalec.spring_test_item_mybatis_std.dto.ItemDto;

public interface ItemDao {
	ArrayList<ItemDto> list();
	void write(String name, int price, String description);
}
