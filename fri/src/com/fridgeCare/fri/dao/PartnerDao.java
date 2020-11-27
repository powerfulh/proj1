package com.fridgeCare.fri.dao;

import java.sql.*;
import java.util.*;

import db.*;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.sql.*;
import com.fridgeCare.fri.util.Hoonpage;

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
	//페이지 처리해주는 기능을 넣은 겟보드리스트
	public ArrayList<PartnerVO> pagination(Hoonpage pageutil){
		ArrayList<PartnerVO> list = new ArrayList<PartnerVO>();
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.SEL_BOARD_INFO);
		stmt = db.getSTMT(con);
		int skipcount = pageutil.Pageset(pageutil.getPresentpage());
		try {
			rs = stmt.executeQuery(sql);
			for(int i = 0; i < skipcount; i++) {
				rs.next();
			}
			for(int i = 0; i < pageutil.getMaxcontent(); i++) {
				if(rs.next()) {
					PartnerVO pVO = new PartnerVO();
					
					pVO.setTitle(rs.getString("title"));
					pVO.setWdate(rs.getDate("wdate"));
					pVO.setWtime(rs.getTime("wdate"));
					pVO.setLcount(rs.getInt("lcount"));
					pVO.setCnt(rs.getInt("cnt"));
					pVO.setId(rs.getString("id"));
					pVO.setMdir(rs.getString("mdir"));
					pVO.setBdir(rs.getString("bdir"));
					pVO.setBno(rs.getInt("bno"));
					
					list.add(pVO);
				}else {
					break;
				}
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
	
	public int getCnt() {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.SEL_BOARD_Count);
		stmt = db.getSTMT(con);
		try {
			rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("count(*)");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close(rs);
		db.close(stmt);
		db.close(con);
		return cnt;
	}
	
	// 조회수 증가 전담 처리 함수
	public int getInsertCnt(int bno) {
		int cnt = 0;
		con = db.getCon();
		String sql = pSQL.getSQL(pSQL.UPDATE_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
