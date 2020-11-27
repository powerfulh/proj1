package com.fridgeCare.fri.controller.member;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.MemberDao;
import com.fridgeCare.fri.util.Thumbnail;


public class JoinProc implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/fri/";
		MultipartRequest multi = null;
		String path = req.getSession().getServletContext().getRealPath("/WEB-INF/resources/avt");
		try {
			multi = new MultipartRequest(req , path , 1024*1024*11 , "utf-8" , new DefaultFileRenamePolicy());
		} catch (IOException e) {
			e.printStackTrace();
//			System.out.println("");
		}
		String parameter1 = multi.getParameter("inputid");
		String parameter2 = multi.getParameter("inputpw");
		String parameter3 = multi.getParameter("inputgen");
		String parameter4 = multi.getParameter("inputmail");
		String parameter5 = multi.getParameter("inputtel");
		String parameter6 = multi.getParameter("inputage");
		String parameter7 = multi.getParameter("inputloc");
		String parameter8;
		int avtno;
		File f = multi.getFile("inputavt");
		MemberDao dao = new MemberDao();
		File t = null;
		String tname = null;
		try {
			long len = f.length();
			parameter8 = multi.getFilesystemName("inputavt");
			avtno = dao.addAvatar(parameter8, f.getPath(), len);
			Thumbnail maker = new Thumbnail(f.getPath() , 0);
			t = maker.make(100, 100);
			tname = t.getName();
		}catch(NullPointerException e) {
			avtno = 999;
		}
		int cnt = dao.addMember(parameter1, parameter2, parameter6, parameter3, parameter4, parameter7, parameter5, avtno);
		if(cnt == 0) {
			System.out.println("join fail");
			view = "/increpas4team/joinpage.fri";
		}else {
			System.out.println("join success");
			req.getSession().setAttribute("SID", parameter1);
		}
		if(avtno != 999) {
			cnt = dao.addThumbnail(dao.getMemberMno(parameter1), t.getPath() , tname);
			if(cnt == 0) {
				System.out.println("thumb insert fail");
			}else {
				System.out.println("thumb insert success");
			}
		}
		return view;
	}

}
