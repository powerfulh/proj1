package com.fridgeCare.fri.vo;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

public class ResipiVO {
	private int time, lcount, cnt;
	private String rname, dir, video, sdate, body, savename, name, id, rdate;
	private Date wdate, rwdate;
	private Time wtime, rwtime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate() {
		SimpleDateFormat form1 = new SimpleDateFormat("yyyy/MM/dd ");
		SimpleDateFormat form2 = new SimpleDateFormat("HH:mm");
		rdate = form1.format(rwdate) + form2.format(rwtime);
	}
	
	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public Date getRwdate() {
		return rwdate;
	}

	public void setRwdate(Date rwdate) {
		this.rwdate = rwdate;
	}

	public Time getRwtime() {
		return rwtime;
	}

	public void setRwtime(Time rwtime) {
		this.rwtime = rwtime;
		setRdate();
	}

	public String getSavename() {
		return savename;
	}

	public void setSavename(String savename) {
		this.savename = savename;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public int getLcount() {
		return lcount;
	}

	public void setLcount(int lcount) {
		this.lcount = lcount;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
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
	

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
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
