package com.fridgeCare.fri.controller.partnerBoard;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.dao.*;

public class PartnerBoard implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		PartnerDao pDao = new PartnerDao(); 
		ArrayList<PartnerVO> board = pDao.getBoardList();
		
		
		
		req.setAttribute("BOARD", board);
		String view = "partnerBoard/partnerBoard";
		return view;
	}

}
