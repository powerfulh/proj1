package com.fridgeCare.fri.controller.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.ResipiDao;

public class ResipiWrite implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		ResipiDao rDao = new ResipiDao();
		String reply = req.getParameter("reply");
		/*
		 * int mno = (int)req.getSession().getAttribute("mno"); int bno =
		 * (int)req.getSession().getAttribute("bno");
		 */
		int mno = 1001;
		int bno = 1001;
		
		rDao.getReplyCnt(bno, reply, mno);
		
		req.setAttribute("isRedirect", true);
		String view = "/fri/resipiPage.fri";
		return view;
	}

}
