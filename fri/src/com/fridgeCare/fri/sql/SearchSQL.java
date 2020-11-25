package com.fridgeCare.fri.sql;

public class SearchSQL {
	public final int SEL_INGRED_INFO = 3002;
	public final int SEL_INGR_CATEGORY = 3001;
	public final int SEL_BOARD	= 2001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_INGR_CATEGORY:
			buff.append("SELECT ");
			buff.append("	ino, iname ");
			buff.append("FROM ");
			buff.append("	ingredient ");
			buff.append("WHERE ");
			buff.append("	category = ? ");
			break;
		case SEL_BOARD:
			buff.append("SELECT ");
			buff.append("	title, bno, lcont, wmno, id,"
						+ " tno, dir, tname, tmno, ");
			buff.append("FROM ");
			buff.append("	board, member, thumb, resipe ");
			buff.append("WHERE ");
			buff.append("	wmno = mno ");
			buff.append("	AND tmno = null ");
			buff.append("	AND ingred = ? ");
			break;
		}
		return buff.toString();
	}
}
