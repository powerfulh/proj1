package com.fridgeCare.fri.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.MemberDao;

public class Bring implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", false);
		String view = "main";
		String loginid = (String) req.getSession().getAttribute("SID");
		if(loginid != null) {
			MemberDao dao = new MemberDao();
			req.setAttribute("AVT", dao.getThumbname(loginid));
		}
		return view;
	}

}
