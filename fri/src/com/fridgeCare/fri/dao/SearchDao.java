package com.fridgeCare.fri.dao;

import java.sql.*;
import com.fridgeCare.fri.sql.*;
import com.fridgeCare.fri.vo.*;


import db.*;

public class SearchDao {
	FriDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	SearchSQL sSQL;
	
	public SearchDao() {
		db = new FriDBCP();
		sSQL = new SearchSQL();
	}
	
	// 버튼 누르면 재료명 받아오는 함수
	public SearchVO getIngeidname(String category) {
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_INGR_CATEGORY);
		pstmt = db.getPSTMT(con, sql);
		SearchVO sVO = new SearchVO();
		try {
			pstmt.setString(1, category);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				sVO.setIno(rs.getInt("ino"));
				sVO.setIname(rs.getString("iname"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return sVO;
	}
	
	
	// 게시물 받아오는 함수
	/* public */
	
}
