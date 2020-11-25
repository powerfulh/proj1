package com.fridgeCare.fri.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.MemberDao;
import com.fridgeCare.fri.vo.LatelyUploadVO;
import com.fridgeCare.fri.vo.WeekVO;

public class Bring implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("isRedirect", false);
		String view = "main";
		MemberDao dao = new MemberDao();
		LatelyUploadVO vo = dao.getLUVO();
		req.setAttribute("LUVO", vo);
		WeekVO wvo = dao.getWVO();
		req.setAttribute("WVO", wvo);
		wvo = dao.getMVO();
		req.setAttribute("MVO", wvo);
		String loginid = (String) req.getSession().getAttribute("SID");
		if(loginid != null) {
			req.setAttribute("AVT", dao.getThumbname(loginid));
		}
		return view;
	}

}
