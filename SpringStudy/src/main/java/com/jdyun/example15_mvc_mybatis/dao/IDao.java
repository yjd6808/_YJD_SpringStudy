package com.jdyun.example15_mvc_mybatis.dao;

import java.util.ArrayList;
import java.util.List;

import com.jdyun.example15_mvc_mybatis.dto.BDto;

public interface IDao {
	public ArrayList<BDto> list();
}