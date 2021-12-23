package com.javalec.spring_test_item_mybatis.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import com.javalec.spring_test_item_mybatis.*;
import com.javalec.spring_test_item_mybatis.dto.ItemDto;


public interface ItemDao {
	
	public ArrayList<ItemDto> list();
	public void write(String name, int price, String description);
			
}
