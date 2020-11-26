package com.fridgeCare.fri.sql;

public class ResipeAddSQL {
	public final int INS_RESIPE_INFO = 2001;
	public final int SEL_RNO_INFO = 1001;
	public final int SEL_TNO_INFO = 1002;
	public final int ADD_BOARD = 3001;
	public final int ADD_THUMB = 3002;
	public final int ADD_BODY = 3003;
	public final int ADD_IMAGE = 3004;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case INS_RESIPE_INFO:
			buff.append("INSERT INTO ");
			buff.append("	resipi(rno, rname, category, ingred, video, time, situat)  ");
			buff.append("VALUES(  ");
			buff.append("	(SELECT NVL(MAX(rno) + 1, 1001) FROM resipi),  ");
			buff.append("	?, ?, ?, ?, ?, ?  ");
			buff.append(") ");
			break;
		case SEL_RNO_INFO:
			buff.append("select  "); 
			buff.append("    rno ");
			buff.append("from ");
			buff.append("    resipi "); 
			buff.append("where ");
			buff.append("    rname = ? and category = ? and ingred = ? and video = ? and time = ? and situat = ? ");
			break;
		case SEL_TNO_INFO:
			buff.append("select ");
			buff.append("    tno ");
			buff.append("from ");
			buff.append("    thumb ");
			buff.append("where ");
			buff.append("    tname = ? ");
			break;
		case ADD_BOARD:
			buff.append(" INSERT INTO ");
			buff.append("board(bno, title, wmno, rno, imgno)  ");
			buff.append(" VALUES(  ");
			buff.append(" ( SELECT  NVL(MAX(bno) + 1, 1001)  ");
			buff.append(" FROM  board  ),  ?,   ");
			buff.append(" (  SELECT  mno  FROM  member WHERE id = ?  ),  ");
			buff.append(" ( SELECT  rno  FROM resipi WHERE  ");
			buff.append(" rname = ? and category = ? and ingred = ?  ");
			buff.append("  and video = ? and time = ? and situat = ?   ");
			buff.append(" ),   ");
			buff.append("  ( SELECT  tno  FROM  thumb   ");
			buff.append("  WHERE tno = ( SELECT  NVL(MAX(tno), 1001)  ");
			buff.append("   FROM  thumb )    )   ");
			break;
		case ADD_THUMB:
			buff.append("INSERT INTO ");
			buff.append("    thumb(tno, dir , tname) ");
			buff.append("VALUES( ");
			buff.append("    ( ");
			buff.append("    SELECT ");
			buff.append("        NVL(MAX(tno) + 1 ,1001) ");
			buff.append("    FROM ");
			buff.append("        thumb ");
			buff.append("    ), ");
			buff.append("    '/img/thumb/', ? ");
			buff.append(") ");
			break;
		case ADD_BODY:
			buff.append("INSERT INTO ");
			buff.append("    body(bono, body, bobno) ");
			buff.append("VALUES( ");
			buff.append("    ( ");
			buff.append("    SELECT ");
			buff.append("        NVL(MAX(bono) + 1 ,1001) ");
			buff.append("    FROM ");
			buff.append("        body ");
			buff.append("    ), ? , (   SELECT ");
			buff.append("                        bno ");
			buff.append("                    FROM ");
			buff.append("                        board ");
			buff.append("                    WHERE ");
			buff.append("                        bno = ( SELECT  NVL(MAX(bno), 1001) ");
			buff.append("                              FROM  board )) ");
			buff.append(") ");
			break;
		case ADD_IMAGE:
			buff.append("INSERT INTO ");
			buff.append("    image(imgno , oriname, savename, len, dir, imgbono) ");
			buff.append("VALUES( ");
			buff.append("    ( ");
			buff.append("    SELECT ");
			buff.append("        NVL(MAX(imgno) + 1 ,10001) ");
			buff.append("    FROM ");
			buff.append("        image ");
			buff.append("    ), ");
			buff.append("    ?, ");
			buff.append("    ?, ");
			buff.append("    ?, ");
			buff.append("    ?, ");
			buff.append("    (   SELECT ");
			buff.append("            bono ");
			buff.append("        FROM ");
			buff.append("            body ");
			buff.append("        WHERE ");
			buff.append("            bono = ( SELECT  NVL(MAX(bono) - ? , 1001) ");
			buff.append("                  FROM  body )) ");
			buff.append(") ");
			break;
		}
		return buff.toString();
	}
}
