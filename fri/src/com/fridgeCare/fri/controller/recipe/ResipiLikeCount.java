package com.fridgeCare.fri.controller.recipe;

import javax.servlet.http.*;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.vo.*;

public class ResipiLikeCount implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("call");
		
		String view = "";
		ResipiDao rDao = new ResipiDao();
		
		String wbno = req.getParameter("bno");
		int bno = Integer.parseInt(wbno);
		System.out.println("게시물 번호 : " + bno);
		
		int cnt = 0;
		
		cnt = rDao.getLikeCnt(bno);
		
		if(cnt != 0) {
			view = "/fri/resipiPage.fri";
			req.setAttribute("isRedirect", true);
		} else {
			view ="recipe/resipiPage";
		}
		
		
		return view;
	}

}
