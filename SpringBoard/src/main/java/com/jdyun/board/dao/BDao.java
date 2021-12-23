package com.jdyun.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.jdyun.board.dto.BDto;

public class BDao { // 값들을 받아서 데이터처리할 것이다.
	DataSource dataSource;

	public BDao() { // 생성자,, 이미 context.xml에 DBCP정보가 셋팅되어있기때문에,
					// 내장객체를 들고오기 위한 초기화과정
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracle");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BDto> list() {
		ArrayList<BDto> dtos = new ArrayList<BDto>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT BID\r\n" + "     , BNAME\r\n" + "     , BTITLE\r\n" + "     , BCONTENT\r\n"
					+ "     , BDATE\r\n" + "     , BHIT\r\n" + "  FROM MVC_BOARD \r\n" + " ORDER BY BID DESC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int bId = rs.getInt("BID"); // column label 사용
				String bName = rs.getString("BNAME");
				String bTitle = rs.getString("BTITLE");
				String bContent = rs.getString("BCONTENT");
				Timestamp bDate = rs.getTimestamp("BDATE");
				int bHit = rs.getInt("BHIT");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit);
				dtos.add(dto);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public void write(String bName, String bTitle, String bContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO MVC_BOARD(bId,bName,bTitle,bContent,bHit) "
					+ "VALUES(MVC_BOARD_SEQ.nextval,?,?,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);

			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public BDto contentView(String strID) {
		upHit(strID); // 조회수 메소드 호출(private)
		BDto dto = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = dataSource.getConnection();
			String sql = "SELECT BID\r\n" + "     , BNAME\r\n" + "     , BTITLE\r\n" + "     , BCONTENT\r\n"
					+ "     , BDATE\r\n" + "     , BHIT\r\n" + "  FROM MVC_BOARD \r\n" + " WHERE bid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strID));
			rs = pstmt.executeQuery();

			if (rs.next()) {
				int bId = rs.getInt("BID");
				String bName = rs.getString("BNAME");
				String bTitle = rs.getString("BTITLE");
				String bContent = rs.getString("BCONTENT");
				Timestamp bDate = rs.getTimestamp("BDATE");
				int bHit = rs.getInt("BHIT");

				dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}

	private void upHit(String bId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE MVC_BOARD SET bHit = bHit +1 WHERE bid = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bId);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public int modify(String bId, String bName, String bTitle, String bContent) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		int ret = 0;

		try {
			conn = dataSource.getConnection();
			String sql = "UPDATE MVC_BOARD SET bName = ?, bTitle = ?, bContent = ? WHERE bid = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bName);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setInt(4, Integer.parseInt(bId));
			ret = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ret;
	}

	public void delete(String strId) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = dataSource.getConnection();
			String sql = "DELETE MVC_BOARD WHERE bid = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(strId));
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}