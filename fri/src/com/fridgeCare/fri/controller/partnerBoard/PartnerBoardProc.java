package com.fridgeCare.fri.controller.partnerBoard;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.PartnerDao;

public class PartnerBoardProc implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "";
		String wbno = req.getParameter("bno");
		int bno = Integer.parseInt(wbno);
		
		System.out.println(bno);
		
		PartnerDao pDao = new PartnerDao();
		
		int cnt = pDao.getInsertCnt(bno);
		
		
		if(cnt == 1) {
			view = "/fri/resipiPage.fri?bno=" + bno;
			req.setAttribute("isRedirect", true);
			System.out.println("조회수 증가 성공");
		} else {
			view = "/fri/partnerBoard.fri";
			System.out.println("조회수 증가 실패");
			req.setAttribute("isRedirect", true);
		}
		return view;
	}

}
