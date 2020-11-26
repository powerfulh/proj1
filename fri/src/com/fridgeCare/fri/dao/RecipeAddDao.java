package com.fridgeCare.fri.dao;

import java.util.*;
import java.sql.*;
import db.*;

import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.sql.*;

public class RecipeAddDao {
	FriDBCP db;
	Connection con;
	Statement stme;
	PreparedStatement pstmt;
	ResultSet rs;
	
	ResipeAddSQL rSQL;
	public RecipeAddDao() {
		db = new FriDBCP();
		rSQL = new ResipeAddSQL();
	}
	
	public int addResipe(ResipeAddVO rVO) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.INS_RESIPE_INFO);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, rVO.getRname());
			pstmt.setString(2, rVO.getCategory());
			pstmt.setString(3, rVO.getIngred());
			pstmt.setString(4, rVO.getVideo());
			pstmt.setString(5, rVO.getFtime());
			pstmt.setString(6, rVO.getSituat());
			
			cnt = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	public int addBoard(ResipeAddVO rVO) {
		int cnt = 0;
		
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_BOARD);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, rVO.getName());
			pstmt.setString(2, rVO.getId());
			pstmt.setString(3, rVO.getRname());
			pstmt.setString(4, rVO.getCategory());
			pstmt.setString(5, rVO.getIngred());
			pstmt.setString(6, rVO.getVideo());
			pstmt.setString(7, rVO.getFtime());
			pstmt.setString(8, rVO.getSituat());
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		
		return cnt;
	}
	
	public int addThumb(String savename) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_THUMB);
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setString(1, savename);
			
			cnt = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	public int addBody(ArrayList<ResipeAddVO> list) {
		int cnt = 0;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_BODY);
		pstmt = db.getPSTMT(con, sql);
		try {
			for(ResipeAddVO l : list) {
				pstmt.setString(1, l.getBody());
				
				cnt += pstmt.executeUpdate();
			}
			System.out.println("바디 입력횟수 : " + cnt);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	
	public int addImage(ArrayList<ResipeAddVO> list) {
		int cnt = 0;
		int listcnt = list.size() - 1;
		con = db.getCon();
		String sql = rSQL.getSQL(rSQL.ADD_IMAGE);
		pstmt = db.getPSTMT(con, sql);
		try {
			for(ResipeAddVO l : list) {
				pstmt.setString(1, l.getOriname());
				pstmt.setString(2, l.getSavename());
				pstmt.setLong(3, l.getLen());
				pstmt.setString(4, l.getDir());
				pstmt.setInt(5, listcnt);
				listcnt--;
				
				cnt += pstmt.executeUpdate();
			}
			System.out.println("바디 입력횟수 : " + cnt);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
