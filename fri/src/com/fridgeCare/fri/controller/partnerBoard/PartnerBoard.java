package com.fridgeCare.fri.controller.partnerBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.util.Hoonpage;

public class PartnerBoard implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		PartnerDao pDao = new PartnerDao(); 
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
			System.out.println("현재 페이지 : " +nowPage);
		} catch(Exception e) {}
		Hoonpage page = new Hoonpage(pDao.getCnt() , 4 , 3 , nowPage);
		ArrayList<PartnerVO> board = pDao.pagination(page);
		
		req.setAttribute("BOARD", board);
		
		ArrayList<Integer> pagelist = page.setoddfixblock();
		req.setAttribute("pagelist", pagelist);
		req.setAttribute("pagination", page);
		
		String view = "partnerBoard/partnerBoard";
		return view;
	}

}
