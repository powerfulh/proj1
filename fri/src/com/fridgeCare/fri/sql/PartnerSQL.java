package com.fridgeCare.fri.sql;

public class PartnerSQL {
	public final int SEL_BOARD_INFO = 1001;
	public final int SEL_BOARD_Count = 1002;
	
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_BOARD_INFO:
			buff.append("SELECT ");
			buff.append("    title, wdate, lcount, cnt, id, (m.dir || m.tname) mdir, (b.dir || b.tname) bdir ");
			buff.append("FROM ");
			buff.append("    board, member, thumb m , thumb b ");
			buff.append("WHERE ");
			buff.append("    wmno = mno ");
			buff.append("    AND b.tno = imgno ");
			buff.append("    AND mno = m.tmno and grade = 10");
			break;
		case SEL_BOARD_Count:
			buff.append("select count(*) from board , member ");
			buff.append("where board.wmno = member.mno and grade = 10");
			break;
		
		}
		
		return buff.toString();
	}
}
