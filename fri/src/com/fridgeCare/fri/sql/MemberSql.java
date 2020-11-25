package com.fridgeCare.fri.sql;

public class MemberSql {
	public final int SEL_ID_CNT = 1001;
	public final int SEL_pno = 1002;
	public final int SEL_member = 1003;
	public final int SEL_logincheck = 1004;
	public final int SEL_avt_byID = 1005;
	public final int SEL_Mail_CNT = 1006;
	public final int SEL_Thumb_byID = 1007;
	public final int SEL_LatelyUpload = 1008;
	public final int Insert_AVATAR = 2001;
	public final int Insert_Member = 2002;
	public final int Insert_Thumb = 2003;
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_ID_CNT:
			buff.append("select ");
			buff.append("count(*) cnt ");
			buff.append("from ");
			buff.append("member ");
			buff.append("where ");
			buff.append("id = ? ");
			break;
		case SEL_Mail_CNT:
			buff.append("select ");
			buff.append("count(*) cnt ");
			buff.append("from ");
			buff.append("member ");
			buff.append("where ");
			buff.append("mail = ? ");
			break;
		case SEL_logincheck:
			buff.append("select ");
			buff.append("count(*) cnt ");
			buff.append("from ");
			buff.append("member ");
			buff.append("where ");
			buff.append("id = ? and pw = ?");
			break;
		case SEL_pno:
			buff.append("select pno from avatar where pname = ?");
			break;
		case SEL_member:
			buff.append("select * from member where id = ?");
			break;
		case SEL_avt_byID:
			buff.append("select * from avatar where pno = ");
			buff.append("(select avt from member where id = ?)");
			break;
		case SEL_Thumb_byID:
			buff.append("select * from thumb where tmno = ");
			buff.append("(select mno from member where id = ?)");
			break;
		case SEL_LatelyUpload:
			buff.append("select bno , board.title , board.wdate , member.id , thumb.tname , image.savename ");
			buff.append("from board , member , thumb , image ");
			buff.append("where member.mno = board.wmno and ");
			buff.append("thumb.tmno = member.mno and board.bno = image.imgbno ");
			buff.append("order by board.bno desc");
			break;
		case Insert_AVATAR:
			buff.append("insert INTO avatar values( ");
			buff.append("nvl((select max(pno) from avatar)+1 , 1000) , ");
			buff.append("? , ? , ?)");
			break;
		case Insert_Member:
			buff.append("insert INTO member( ");
			buff.append("MNO,ID,PW,AGE,GEN,MAIL,LOCAL,TEL,AVT ");
			buff.append(")values(nvl((select max(mno) from member)+1 , 1000) , ");
			buff.append("? , ? , ? , ? , ? , ? , ? , ?)");
			break;
		case Insert_Thumb:
			buff.append("insert INTO thumb values( ");
			buff.append("? , ? , ? , ?) ");
			break;
		}
		return buff.toString();
	}
}
