package com.fridgeCare.fri.controller.recipe;

import java.util.*;

import javax.servlet.http.*;

import com.fridgeCare.fri.controller.*;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.util.*;
import com.fridgeCare.fri.vo.*;

public class ResipiPage implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		ResipiDao rDao = new ResipiDao();
		ResipiVO rVO = new ResipiVO();
		ArrayList<ResipiVO> list = new ArrayList<ResipiVO>();
		
		/*
		String wbno = req.getParameter("bno"); 
		int bno = Integer.parseInt(wbno); 
		if(wbno == null) {
		}
		 */
	 	
		int bno = 1001;
		System.out.println(bno);
		
		rVO = rDao.getResipi(bno);
		System.out.println(rVO.getVideo());
		list = rDao.getBody(bno);
		
		String ingredient = rDao.getIngred(bno);
		
		System.out.println(ingredient);
		
		String[] ing = ingredient.split("/");
		
		
		ArrayList<ResipiVO> ingred = new ArrayList<ResipiVO>();
		
		for(String s : ing) {
			ResipiVO vo = new ResipiVO();
			vo.setName(s);
			
			ingred.add(vo);
		}
		
		/* String ingr = req.getParameter("INGRED"); */
		String ingr = "당근/";
		ArrayList<ResipiVO> other = rDao.getOther(ingr);
		
		// 파라미터 받고
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(req.getParameter("nowPage"));
			System.out.println("현재 페이지 : " +nowPage);
		} catch(Exception e) {}
		
		// PageUtil 만들고
		int total = rDao.getAllCnt();
		
		PageUtil page = new PageUtil(nowPage, total);
		
		ArrayList<ResipiVO> reply = rDao.getReply(bno,page);
		
		/* String id = (String)req.getSession().getAttribute("SID"); */
		String id = "jiwoo";
		int cnt = rDao.getCnt(id);
		
		req.setAttribute("BODY", list);
		req.setAttribute("INGRED", ingred);
		req.setAttribute("REPLY", reply);
		req.setAttribute("RESIPI", rVO);
		req.setAttribute("PAGE", page);
		req.setAttribute("CNT", cnt);
		req.setAttribute("OTHER", other);
		
		String view = "recipe/resipiPage";
		return view;
	}

}
