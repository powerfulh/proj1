package com.fridgeCare.fri.dao;

import java.sql.*;
import java.util.*;

import db.*;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.sql.*;
import com.fridgeCare.fri.util.PageUtil;

public class PartnerDao {
	FriDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	PartnerSQL pSQL;
	
	public PartnerDao() {
		db = new FriDBCP();
		pSQL = new PartnerSQL();
	}
	
	// 게시판 정보 가져오기 전담 처리 함수
	public ArrayList<PartnerVO> getBoardList(){
		ArrayList<PartnerVO> list = new ArrayList<PartnerVO>();
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.SEL_BOARD_INFO);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				PartnerVO pVO = new PartnerVO();
				
				pVO.setTitle(rs.getString("title"));
				pVO.setWdate(rs.getDate("wdate"));
				pVO.setWtime(rs.getTime("wdate"));
				pVO.setLcount(rs.getInt("lcount"));
				pVO.setCnt(rs.getInt("cnt"));
				pVO.setId(rs.getString("id"));
				pVO.setMdir(rs.getString("mdir"));
				pVO.setBdir(rs.getString("bdir"));
				
				list.add(pVO);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		
		return list;
	}
	
}
