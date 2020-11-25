package com.fridgeCare.fri.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import db.FriDBCP;
import com.fridgeCare.fri.sql.MemberSql;
import com.fridgeCare.fri.vo.LatelyUploadVO;
import com.fridgeCare.fri.vo.WeekVO;

public class MemberDao {
	FriDBCP db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	MemberSql sql;
	public MemberDao() {
		db = new FriDBCP();
		sql = new MemberSql();
	}
	public LatelyUploadVO getLUVO() {
		LatelyUploadVO vo = new LatelyUploadVO();
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_LatelyUpload);
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery(q);
			rs.next();
			vo.setBno(rs.getInt("bno"));
			vo.setId(rs.getString("id"));
			vo.setSavename(rs.getString("savename"));
			vo.setTitle(rs.getString("title"));
			vo.setTname(rs.getString("tname"));
			vo.setWdate(rs.getDate("wdate"));
			vo.setWtime(rs.getTime("wdate"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close(rs);
		db.close(stmt);
		db.close(con);
		return vo;
	}
	public WeekVO getWVO() {
		WeekVO vo = new WeekVO();
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_Week);
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery(q);
			rs.next();
			vo.setBno(rs.getInt("bno"));
			vo.setId(rs.getString("id"));
			vo.setTitle(rs.getString("title"));
			vo.setTname(rs.getString("tname"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close(rs);
		db.close(stmt);
		db.close(con);
		return vo;
	}
	public WeekVO getMVO() {
		WeekVO vo = new WeekVO();
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_Month);
		try {
			stmt = con.createStatement();
			rs= stmt.executeQuery(q);
			rs.next();
			vo.setBno(rs.getInt("bno"));
			vo.setId(rs.getString("id"));
			vo.setTitle(rs.getString("title"));
			vo.setTname(rs.getString("tname"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close(rs);
		db.close(stmt);
		db.close(con);
		return vo;
	}
	public int getIdCnt(String id) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_ID_CNT);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int getMailCnt(String mail) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_Mail_CNT);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, mail);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int getIdCnt(String id , String pw) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_logincheck);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("cnt");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public int getMemberMno(String id) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_member);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("mno");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
	public String getAvatarPname(String id) {
		String pname = null;
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_avt_byID);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			pname = rs.getString("pname");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return pname;
	}
	public String getThumbname(String id) {
		String tname = null;
		con = db.getCon();
		String q = sql.getSQL(sql.SEL_Thumb_byID);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			rs.next();
			tname = rs.getString("tname");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			db.close(rs);
			db.close(pstmt);
			db.close(con);
		}
		return tname;
	}
	public int addAvatar(String savename , String dir , long len) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.Insert_AVATAR);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, savename);
			pstmt.setString(2, dir);
			pstmt.setLong(3, len);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(cnt == 0) {
			System.out.println("avt upload fail");
		}else {
			System.out.println("avt upload success");
		}
		q = sql.getSQL(sql.SEL_pno);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, savename);
			rs = pstmt.executeQuery();
			rs.next();
			cnt = rs.getInt("pno");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		db.close(pstmt);
		db.close(con);
		return cnt;
	}
	public int addMember(String ID,String PW,String AGE,String GEN,String MAIL,String LOCAL,String TEL,int AVT) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.Insert_Member);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setString(1, ID);
			pstmt.setString(2, PW);
			pstmt.setString(3, AGE);
			pstmt.setString(4, GEN);
			pstmt.setString(5, MAIL);
			pstmt.setString(6, LOCAL);
			pstmt.setString(7, TEL);
			pstmt.setInt(8, AVT);
			cnt = pstmt.executeUpdate();
		}catch(SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close(pstmt);
		db.close(con);
		return cnt;
	}
	public int addThumbnail(int mno,String dir,String tname) {
		int cnt = 0;
		con = db.getCon();
		String q = sql.getSQL(sql.Insert_Thumb);
		pstmt = db.getPSTMT(con, q);
		try {
			pstmt.setInt(1, mno);
			pstmt.setString(2, dir);
			pstmt.setString(3, tname);
			pstmt.setInt(4, mno);
			cnt = pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		db.close(pstmt);
		db.close(con);
		return cnt;
	}
}
