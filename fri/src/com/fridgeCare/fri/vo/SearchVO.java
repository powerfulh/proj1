package com.fridgeCare.fri.vo;

import java.sql.Date;
import java.text.SimpleDateFormat;


public class SearchVO {
	private int ino,  lcount, bno, wmno, tno;
	private String iname, category, imgdir, title, tname, tmno, thumdir, rdate;
	private Date wdate;
	public int getIno() {
		return ino;
	}
	public void setIno(int ino) {
		this.ino = ino;
	}
	public String getIname() {
		return iname;
	}
	public void setIname(String iname) {
		this.iname = iname;
	}
	public int getLcount() {
		return lcount;
	}
	public void setLcount(int lcount) {
		this.lcount = lcount;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public int getWmno() {
		return wmno;
	}
	public void setWmno(int wmno) {
		this.wmno = wmno;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImgdir() {
		return imgdir;
	}
	public void setImgdir(String imgdir) {
		this.imgdir = imgdir;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTmno() {
		return tmno;
	}
	public void setTmno(String tmno) {
		this.tmno = tmno;
	}
	public String getThumdir() {
		return thumdir;
	}
	public void setThumdir(String thumdir) {
		this.thumdir = thumdir;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public void setWdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("YY/MM/dd");
		rdate = form1.format(wdate);
	}
	
}
