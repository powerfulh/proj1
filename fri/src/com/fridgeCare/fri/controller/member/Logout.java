package com.fridgeCare.fri.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fridgeCare.fri.controller.Caller;


public class Logout implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", true);
		String view = "/fri/";
		HttpSession session = req.getSession();
		session.removeAttribute("SID");
		return view;
	}

}
