package com.fridgeCare.fri.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.MemberDao;

public class LoginCheck implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/fri/";
		String parameter1 = req.getParameter("inputid");
		String parameter2 = req.getParameter("inputpw");
		MemberDao dao = new MemberDao();
		int cnt = dao.getIdCnt(parameter1, parameter2);
		if(cnt == 0) {
			System.out.println("login fail");
			view = "/fri/?fail";
		}else {
			System.out.println("login success");
			req.getSession().setAttribute("SID", parameter1);
		}
		return view;
	}

}
