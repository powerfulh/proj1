package com.fridgeCare.fri.sql;

public class ResipiSQL {
	public final int SEL_RESIPI_INFO = 1001;
	public final int SEL_BODY_INFO = 1002;
	public final int SEL_INGRED_INFO = 1003;
	public final int SEL_REPLY_INFO = 1004;
	public final int SEL_REPLY_ALL_CNT = 1005;
	public final int SEL_REPLY_CNT = 1006;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_RESIPI_INFO:
			buff.append("SELECT ");
			buff.append("    dir,rname,video,wdate,body,lcount,cnt,time ");
			buff.append("FROM ");
			buff.append("    board b, image i, resipi r, body bo ");
			buff.append("WHERE ");
			buff.append("    bno = imgbno ");
			buff.append("    AND brno = rno ");
			buff.append("    AND bno = bobno ");
			buff.append("    AND imgbono = bono ");
			buff.append("    AND bno = ? ");
			break;
		case SEL_BODY_INFO:
			buff.append("SELECT ");
			buff.append("    body, dir ");
			buff.append("FROM ");
			buff.append("    body, image ");
			buff.append("WHERE ");
			buff.append("    bobno = ? ");
			buff.append("    AND bobno = imgbno ");
			buff.append("    AND bono = imgbono ");
			break;
		case SEL_INGRED_INFO:
			buff.append("SELECT ");
			buff.append("    ingred ");
			buff.append("FROM ");
			buff.append("    resipi, board ");
			buff.append("WHERE ");
			buff.append("    bno = ? ");
			buff.append("    AND brno = rno ");
			break;
		case SEL_REPLY_INFO:
			buff.append("SELECT ");
			buff.append("    * ");
			buff.append("FROM ");
			buff.append("    ( ");
			buff.append("        SELECT ");
			buff.append("            rownum rno, re.* ");
			buff.append("        FROM ");
			buff.append("            (SELECT ");
			buff.append("                body, id ,redate ");
			buff.append("            FROM ");
			buff.append("                reply, member, board ");
			buff.append("            WHERE ");
			buff.append("                bno = ? ");
			buff.append("                AND remno = mno ");
			buff.append("                AND rebno = bno ");
			buff.append("            ORDER BY ");
			buff.append("                redate DESC) re ");
			buff.append("    ) ");
			buff.append("WHERE ");
			buff.append("    rno BETWEEN ? AND ? ");
			break;
		case SEL_REPLY_ALL_CNT:
			buff.append("SELECT ");
			buff.append("	COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("	reply ");
			break;
		case SEL_REPLY_CNT:
			buff.append("SELECT ");
			buff.append("    COUNT(*) cnt ");
			buff.append("FROM ");
			buff.append("    member, reply ");
			buff.append("WHERE ");
			buff.append("    mno = remno ");
			buff.append("    AND id = ? ");
			break;
		}
		
		return buff.toString();
	}
}
