package com.fridgeCare.fri.dao;

import java.sql.*;
import java.util.ArrayList;

import com.fridgeCare.fri.sql.*;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.util.PageUtil;

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
	public ArrayList <SearchVO> getIngeidname() {
		con = db.getCon();
		String sql = sSQL.getSQL(sSQL.SEL_INGR_CAT);
		stmt = db.getSTMT(con);
		ArrayList<SearchVO> getingredlist = new ArrayList <SearchVO>();
		try {			
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				SearchVO sVO = new SearchVO();
				sVO.setIno(rs.getInt("ino"));
				sVO.setIname(rs.getString("iname"));
				sVO.setCategory(rs.getString("category"));
				sVO.setSavename(rs.getString("savename"));
				
				getingredlist.add(sVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return getingredlist ;
	}
	
	
	// 선택한 게시물 받아오는 함수
	public ArrayList<SearchVO> getBoardList(PageUtil page){
		ArrayList<SearchVO> list = new ArrayList<SearchVO>();
		// 할일
		// 1. connection 가져오고
		con = db.getCon();
		// 2. 질의명령 가져오고
		String sql = sSQL.getSQL(sSQL.SEL_BOARD);
		// 3. 스테이트먼트 가져오고
		pstmt = db.getPSTMT(con, sql);
		try {
			// 4. 질의명령 완성하고
			pstmt.setInt(1, page.getStartCont());
			pstmt.setInt(2, page.getEndCont());
			// 5. 질의명령 보내고 결과받고
			rs = pstmt.executeQuery();
			// 6. 결과에서 데이터꺼내서 리스트에 담고
			while(rs.next()) {
				// VO 만들고
				SearchVO sVO = new SearchVO();
				
				// 데이터 채우고
				sVO.setBno(rs.getInt("bno"));
				sVO.setTitle(rs.getString("title"));
				sVO.setWmno(rs.getInt("wmno"));
				sVO.setLcount(rs.getInt("lcount"));
				sVO.setTime(rs.getInt("time"));
				sVO.setIngred(rs.getString("ingred"));
				sVO.setTno(rs.getInt("tno"));
				sVO.setMdir(rs.getString("mdir"));
				sVO.setBdir(rs.getString("bdir"));
				
				// 리스트에 담고
				list.add(sVO);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		// 7. 리스트 반환해주고...
		return list;
	} 
	
	// 카테고리 선택한 게시글 수 조회
		public int getCnt(String category) {
			int cnt = 0 ; 
			con = db.getCon();
			String sql = sSQL.getSQL(sSQL.SEL_CNT);
			pstmt = db.getPSTMT(con,sql);
			try {
				// 질의명령 보내고 결과받고
				pstmt.setString(1, category);
				
				rs = pstmt.executeQuery();
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
		
//		// 카테고리별 게시글 수 조회 전담 처리함수
//		public int getCcnt() {
//			int cnt = 0 ; 
//			con = db.getCon();
//			String sql = sSQL.getSQL(sSQL.SEL_INGRED_CNT);
//			stmt = db.getSTMT(con);
//			try {
//				// 질의명령 보내고 결과받고
//				rs = stmt.executeQuery(sql);
//				// 결과값이 한행이므로
//				rs.next();
//				cnt = rs.getInt("cnt");
//			} catch(Exception e) {
//				e.printStackTrace();
//			} finally {
//				db.close(rs);
//				db.close(stmt);
//				db.close(con);
//			}
//			
//			return cnt;
//		}
	
}
