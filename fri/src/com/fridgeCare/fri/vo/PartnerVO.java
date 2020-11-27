package com.fridgeCare.fri.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class PartnerVO {
	private int cnt, lcount, bno;
	private String id, sdate, title ,bdir ,mdir ;
	private Date wdate;
	private Time wtime;
	

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getLcount() {
		return lcount;
	}

	public void setLcount(int lcount) {
		this.lcount = lcount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBdir() {
		return bdir;
	}

	public void setBdir(String bdir) {
		this.bdir = bdir;
	}

	public String getMdir() {
		return mdir;
	}

	public void setMdir(String mdir) {
		this.mdir = mdir;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		sdate = form1.format(wdate) + form2.format(wtime);
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public Time getWtime() {
		return wtime;
	}

	public void setWtime(Time wtime) {
		this.wtime = wtime;
		setSdate();
	}

}
