package com.fridgeCare.fri.controller.jooRecipe;

import javax.servlet.http.*;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.vo.*;

import java.util.*;

public class RecipeAddProc implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("call");
		String view ="/fri/recipe/resipiPage.fri";
		req.setAttribute("isRedirect", true);
		// fri/recipeAddProc.fri?rname=xxxx&cate=XXXXXXXX
		String rname = req.getParameter("name");
		String cate = req.getParameter("cate");
		String ftime = req.getParameter("time");
		String ingred = req.getParameter("ingre");
		String video = req.getParameter("video");
		String situat = req.getParameter("situat");
		
		ResipeAddVO rVO = new ResipeAddVO();
		rVO.setRname(rname);
		rVO.setCategory(cate);
		rVO.setIngred(ingred);
		rVO.setVideo(video);
		rVO.setFtime(ftime);
		rVO.setSituat(situat);
		
		RecipeAddDao rDao = new RecipeAddDao();
		int cnt = rDao.addResipe(rVO);
		
		if(cnt == 0) {
			return "/fri/recipe/recipeAdd.fri";
		}
		
		return view;
	}

}
