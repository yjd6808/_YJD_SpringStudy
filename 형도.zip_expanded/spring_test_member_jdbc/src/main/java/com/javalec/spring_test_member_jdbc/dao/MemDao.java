package com.javalec.spring_test_member_jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.javalec.spring_test_member_jdbc.dto.MemDto;
import com.javalec.spring_test_member_jdbc.util.Constant;

public class MemDao {
	
	DataSource dataSource;
	JdbcTemplate template = null;
	
	public MemDao() {
//		try {
//			Context ctx = new InitialContext();
//			dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/oracle");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		template = Constant.template;
	}
	
	
//	public int loginYn(final String memUid, String memPwd) {
//		
//		String sql =	"  SELECT MEM_PWD\r\n"
//						+ "  FROM MVC_MEMBER"
//						+ " WHERE MEM_UID = ?";
//		
//		List<String> pwList =  template.query(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				ps.setString(1, memUid);
//			}
//		}, 
//		new RowMapper<String>() {
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//                return rs.getString(1);
//            }	
//		});
//		
//		int re = -1;
//		if (pwList.size() > 0) {
//			if (pwList.get(0).equals(memPwd)) {
//				re = 1;  
//			}else { // id는 맞는데 pw가 틀림.
//				re = 0;
//			}			
//		} else {
//			re = -1;
//		}
//		return re;
		
		public ArrayList<MemDto> loginYn(final String memUid) {
			
			String sql =	"  SELECT MEM_PWD\r\n"
							+ "  FROM MVC_MEMBER"
							+ " WHERE MEM_UID = '"+memUid +"'";
			
			return (ArrayList<MemDto>) template.query(sql, new BeanPropertyRowMapper(MemDto.class));
		
		
		
		
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		int re = -1;  // -1이 기본값
//		String sql = "";
//		String db_mem_pwd;
//		
//		System.out.println("dao");
//		
//		try {
//			conn = dataSource.getConnection();
//			sql =	"  SELECT MEM_PWD\r\n"
//					+ "  FROM MVC_MEMBER"
//					+ " WHERE MEM_UID = ?";
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, memUid);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				db_mem_pwd = rs.getString("MEM_PWD");
//				
//				if (db_mem_pwd.equals(memPwd)) { // id랑 pw 맞음.
//					re = 1;  
//				}else { // id는 맞는데 pw가 틀림.
//					re = 0;
//				}
//			}else { // id가 틀림 
//				re = -1;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if (rs != null) rs.close();
//				if (pstmt != null) pstmt.close();
//				if (conn != null) conn.close();
//			} catch (Exception e2) {
//				e2.printStackTrace();
//			}
//		}
//		return re;
	}
	
	public void write(final String memUid, final String memPwd, final String memName) {
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String sql = "insert into mvc_member values(?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, memUid);
				pstmt.setString(2, memPwd);
				pstmt.setString(3, memName);
				return pstmt;
			}
		});
	}
	

	
}
