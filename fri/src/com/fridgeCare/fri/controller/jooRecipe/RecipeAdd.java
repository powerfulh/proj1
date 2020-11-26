package com.fridgeCare.fri.controller.jooRecipe;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.RecipeAddDao;

public class RecipeAdd implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "joo/recipeAdd";
		
		int cnt = 0;
		
		String sno = req.getParameter("addcnt");
		try{
			cnt = Integer.parseInt(sno);
		} catch(Exception e) {cnt = 0;}
		
		req.setAttribute("ADDCNT", cnt);
		
		return view;
	}

}
