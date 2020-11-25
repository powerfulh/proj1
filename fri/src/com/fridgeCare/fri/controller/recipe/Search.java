package com.fridgeCare.fri.controller.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;

public class Search implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "search";
		String parameter1 = req.getParameter("category");
		return view;
	}
}
