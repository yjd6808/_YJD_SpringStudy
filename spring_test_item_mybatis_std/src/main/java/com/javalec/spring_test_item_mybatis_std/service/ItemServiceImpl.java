package com.javalec.spring_test_item_mybatis_std.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javalec.spring_test_item_mybatis_std.dao.ItemDao;
import com.javalec.spring_test_item_mybatis_std.dto.ItemDto;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public ArrayList<ItemDto> list() {
		return sqlSession.getMapper(ItemDao.class).list();
	}

	@Override
	public void write(HashMap<String, String> param) {
		sqlSession.getMapper(ItemDao.class).write(
					param.get("name"),
					Integer.parseInt(param.get("price")),
					param.get("description")
				);
	}

}
