package com.fridgeCare.fri.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;

public class PartnerBoard implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "partnerboard/?";
		
		return view;
	}

}
