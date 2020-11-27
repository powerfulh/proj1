package com.fridgeCare.fri.sql;

public class SearchSQL {
	// 해당하는 재료 불러오기
	public final int SEL_INGR_CAT = 1001;
	
	// 모든 레시피 게시물 수 조회
	public final int SEL_CNT = 1002;

	// 카테고리별 정렬
	public final int SEL_BOARD_CAT = 1003;
	
	// 전체 게시물 조회
	public final int SEL_BOARD	= 2001;
	
	// 조회수 증가
	public final int INCRE_CNT	= 4001;

	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_INGR_CAT:
			buff.append("SELECT ");
			buff.append("	* ");
			buff.append("FROM ");
			buff.append("	ingredient ");
			break;
		case SEL_BOARD:
			buff.append("SELECT "); 
			buff.append("    bd.bno, bd.title, bd.wmno, bd.lcount, r.time, r.ingred, m.tno,(m.dir || m.tname) mdir, (b.dir || b.tname) bdir "); 
			buff.append("FROM "); 
			buff.append("    BOARD bd, member, resipi r, thumb m, thumb b "); 
			buff.append("WHERE "); 
			buff.append("    wmno = mno "); 
			buff.append("    AND m.tmno = mno "); 
			buff.append("    AND bd.rno = r.rno "); 
			buff.append("    AND b.tno = bd.imgno "); 
			buff.append("    AND r.INGRED LIKE( ? ) ");
			break;
		case SEL_CNT:
			buff.append("SELECT "); 
			buff.append("    count(*) cnt "); 
			buff.append("FROM "); 
			buff.append("    resipi "); 
			buff.append("WHERE "); 
			buff.append("    category = ? ");
			break;
		case INCRE_CNT:
			buff.append("UPDATE "); 
			buff.append("    BOARD "); 
			buff.append("SET "); 
			buff.append("    CNT = CNT + 1 "); 
			buff.append("WHERE "); 
			buff.append("    bno = ? "); 
			break;
		case SEL_BOARD_CAT:
			buff.append("SELECT "); 
			buff.append("    bd.bno, bd.title, bd.wmno, bd.lcount,  r.time, r.ingred, m.tno,(m.dir || m.tname) mdir, (b.dir || b.tname) bdir "); 
			buff.append("FROM "); 
			buff.append("    BOARD bd, member, resipi r, thumb m, thumb b "); 
			buff.append("WHERE "); 
			buff.append("    wmno = mno "); 
			buff.append("    AND m.tmno = mno "); 
			buff.append("    AND bd.rno = r.rno "); 
			buff.append("    AND b.tno = bd.imgno "); 
			buff.append("    AND category = ? ; "); 
			break;
		}
		return buff.toString();
	}
}
