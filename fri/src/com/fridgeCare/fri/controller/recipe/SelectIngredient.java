package com.fridgeCare.fri.controller.recipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;

public class SelectIngredient implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "selectIngredient";
		String parameter1 = req.getParameter("category");
		//현욱이형 파이팅
		return view;
	}
}
