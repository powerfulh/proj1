package com.fridgeCare.fri.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.MemberDao;


public class IdCheck implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", null);
		String parameter1 = req.getParameter("id");
		MemberDao dao = new MemberDao();
		int cnt = dao.getIdCnt(parameter1);
		String data;
		if(cnt == 0) {
			data = "{\"result\" : \"OK\"}";
		}else {
			data = "{\"result\" : \"NO\"}";
		}
		return data;
	}

}
