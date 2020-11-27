package com.fridgeCare.fri.sql;

public class ResipiSQL {
	public final int SEL_RESIPI_INFO = 1001;
	public final int SEL_BODY_INFO = 1002;
	public final int SEL_INGRED_INFO = 1003;
	public final int SEL_REPLY_INFO = 1004;
	public final int SEL_REPLY_ALL_CNT = 1005;
	public final int SEL_REPLY_CNT = 1006;
	public final int SEL_OTHER_INFO = 1007;
	
	public final int ADD_LIKE_COUNT = 2001;
	public final int ADD_REPLY_BODY = 2002;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_RESIPI_INFO:
			buff.append("SELECT ");
			buff.append("    dir,rname,video,wdate,lcount,cnt,time,bno ");
			buff.append("FROM ");
			buff.append("    board b, thumb t, resipi r ");
			buff.append("WHERE ");
			buff.append("    imgno = tno ");
			buff.append("    AND b.rno = r.rno ");
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
			buff.append("    resipi r, board b ");
			buff.append("WHERE ");
			buff.append("    bno = ? ");
			buff.append("    AND r.rno = b.rno ");
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
		case SEL_OTHER_INFO:
			buff.append("SELECT ");
			buff.append("    * ");
			buff.append("FROM ");
			buff.append("   (SELECT ");
			buff.append("       rownum rno, re.* ");
			buff.append("   FROM ");
			buff.append("       (SELECT ");
			buff.append("           rname, dir, bno ");
			buff.append("       FROM  ");
			buff.append("            resipi r , board b, thumb t ");
			buff.append("       WHERE  ");
			buff.append("           tno = imgno ");
			buff.append("			AND r.rno = b.rno ");
		    buff.append("    		AND ingred LIKE '%' || ? || '%' ");
			buff.append("       ORDER BY ");
			buff.append("           rname DESC) re) ");
			buff.append("WHERE ");
			buff.append("	rno  <= 5 ");
			break;
		case ADD_LIKE_COUNT:
			buff.append("UPDATE ");
			buff.append("    board ");
			buff.append("SET ");
			buff.append("    lcount = lcount + 1 ");
			buff.append("WHERE ");
			buff.append("    bno = ? ");
			break;
		case ADD_REPLY_BODY:
			buff.append("INSERT INTO ");
			buff.append("    reply(reno, rebno, body, remno, redate) ");
			buff.append("VALUES( ");
			buff.append("    (SELECT NVL(MAX(reno) + 1, 10001) FROM reply), ");
			buff.append("    ? , ? , ?, sysdate ");
			buff.append(") ");
			break;
		}
		
		return buff.toString();
	}
}
