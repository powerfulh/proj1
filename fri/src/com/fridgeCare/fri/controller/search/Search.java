package com.fridgeCare.fri.controller.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.vo.*;

public class Search implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		SearchDao sDao = new SearchDao();
		SearchVO sVO = new SearchVO();
		String ingred = req.getParameter("ingred");
		
		String view = "search/search";
		String SelCat = req.getParameter("category");
		String bno = req.getParameter("bno");
		
		
		
		
		/* ArrayList<SearchVO> ingred = new ArrayList<SearchVO>(); */
		
		return view;
	}
}
