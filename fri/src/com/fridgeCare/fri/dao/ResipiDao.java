package com.fridgeCare.fri.dao;

import java.sql.*;
import java.util.*;

import db.*;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.sql.*;
import com.fridgeCare.fri.util.PageUtil;

public class ResipiDao {
	FriDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ResipiSQL rSQL;
	
	public ResipiDao() {
		db = new FriDBCP();
		rSQL = new ResipiSQL();
	}
	
	// 레시피 정보 가져오기 전담 처리 함수
	public ResipiVO getResipi(int bno) {
		ResipiVO rVO = new ResipiVO();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_RESIPI_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				rVO.setBno(rs.getInt("bno"));
				rVO.setRname(rs.getString("rname"));
				rVO.setVideo(rs.getString("video"));
				rVO.setDir(rs.getString("dir"));
				rVO.setWdate(rs.getDate("wdate"));
				rVO.setWtime(rs.getTime("wdate"));
				rVO.setLcount(rs.getInt("lcount"));
				rVO.setCnt(rs.getInt("cnt"));
				rVO.setTime(rs.getInt("time"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return rVO;
	}
	
	// 재료 설명 가져오기 전담 처리함수
	public ArrayList<ResipiVO> getBody(int bno){
		ArrayList<ResipiVO> list = new ArrayList<ResipiVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_BODY_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ResipiVO rVO = new ResipiVO();
				rVO.setBody(rs.getString("body"));
				rVO.setDir(rs.getString("dir"));
				
				list.add(rVO);
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
	
	// 재료 가져오기 전담 처리 함수
	public String getIngred(int bno) {
		String ingred = "";
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_INGRED_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			ingred = rs.getString("ingred");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return ingred;
	}
	
	//댓글 가져오기 전담 처리 함수
	public ArrayList<ResipiVO> getReply(int bno, PageUtil page){
		ArrayList<ResipiVO> list = new ArrayList<ResipiVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_REPLY_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			pstmt.setInt(2, page.getStartCont());
			pstmt.setInt(3, page.getEndCont());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ResipiVO rVO = new ResipiVO();
				rVO.setId(rs.getString("id"));
				rVO.setBody(rs.getString("body"));
				rVO.setRwdate(rs.getDate("redate"));
				rVO.setRwtime(rs.getTime("redate"));
				
				list.add(rVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return list;
	}
	
	// 게시글 수 조회 전담 처리함수
	public int getAllCnt() {
		int cnt = 0 ; 
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_REPLY_ALL_CNT);
		stmt = db.getSTMT(con);
		try {
			// 질의명령 보내고 결과받고
			rs = stmt.executeQuery(sql);
			// 결과값이 한행이므로
			rs.next();
			cnt = rs.getInt("cnt");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(stmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	// 유저 댓글 확인 전담 처리 함수
	public int getCnt(String id) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_REPLY_CNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 선택 재료로 가능한 레시피 불러오기 전담 처리 함수
	public ArrayList<ResipiVO> getOther(String ingred){
		ArrayList<ResipiVO> list = new ArrayList<ResipiVO>();
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.SEL_OTHER_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			System.out.println(ingred);
			pstmt.setString(1, ingred);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("list 사이즈 : " + list.size());
				ResipiVO rVO = new ResipiVO();
				
				rVO.setDir(rs.getString("dir"));
				rVO.setName(rs.getString("rname"));
				rVO.setBno(rs.getInt("bno"));
				System.out.println("bno 값 : " + rVO.getBno());
				
				list.add(rVO);
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
	
	public int getLikeCnt(int bno) {
		int cnt = 0;
		con =db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_LIKE_COUNT);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	// 리뷰 저장 전담 처리 함수
	public void getReplyCnt(int bno, String reply, int mno) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_REPLY_BODY);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, bno);
			pstmt.setString(2, reply);
			pstmt.setInt(3, mno);
			
			cnt = pstmt.executeUpdate();
			System.out.println("댓글 작성 여부 : " + cnt);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
	}
}
