package com.javalec.spring_test_member_jdbc.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	public static JdbcTemplate template;
	public static SqlSession sqlSession;
}
