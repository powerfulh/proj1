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
			db.close(pstmt);
			db.close(con);
		}
		return cnt;
	}
}
