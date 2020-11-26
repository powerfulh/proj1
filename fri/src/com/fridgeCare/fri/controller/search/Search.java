package com.fridgeCare.fri.controller.search;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.vo.*;
import com.fridgeCare.fri.util.*;

public class Search implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		String view = "search/search";
		SearchDao sDao = new SearchDao();
		SearchVO sVO = new SearchVO();
		
		String ingred = req.getParameter("ingred");
		
		String SelCat = req.getParameter("category");
		String bno = req.getParameter("bno");
		System.out.println(SelCat);
		
		
		
		// 파라미터 받기
		int nowPage = 1;
		
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
		} catch(Exception e) {}
		
		// page util 만들기
		int total = sDao.getCnt(SelCat);
		
		PageUtil page = new PageUtil(nowPage, total);	
		
		ArrayList<SearchVO> getingredlist = new ArrayList<SearchVO>();
		getingredlist = sDao.getIngeidname();
		req.setAttribute("LIST", getingredlist);
		
		return view;
	}
}
