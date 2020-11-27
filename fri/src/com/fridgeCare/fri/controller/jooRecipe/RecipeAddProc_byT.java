  package com.fridgeCare.fri.controller.jooRecipe;

import javax.servlet.http.*;

import com.fridgeCare.fri.controller.Caller;
import com.fridgeCare.fri.dao.*;
import com.fridgeCare.fri.vo.*;
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;

public class RecipeAddProc_byT implements Caller {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//System.out.println("call");
		
		String view ="joo/redirect";
		// fri/recipeAddProc.fri?rname=xxxx&cate=XXXXXXXX
		String id = (String)req.getSession().getAttribute("SID");
		
		String path = req.getSession().getServletContext().getRealPath("WEB-INF/resources/img/thumb");
		ResipeAddVO rVO = new ResipeAddVO();
		RecipeAddDao rDao = new RecipeAddDao();
		try {
			MultipartRequest multi = new MultipartRequest(req, path, 1024*1024*10, "UTF-8",
																new DefaultFileRenamePolicy());
			String name = multi.getParameter("board");
			String rname = multi.getParameter("name");
			String cate = multi.getParameter("cate");
			String ftime = multi.getParameter("time");
			String ingred = multi.getParameter("ingre");
			String video = multi.getParameter("video");
			String situat = multi.getParameter("situat");
			
			rVO.setId(id);
			rVO.setName(name);
			rVO.setRname(rname);
			rVO.setCategory(cate);
			rVO.setIngred(ingred);
			rVO.setVideo(video);
			rVO.setFtime(ftime);
			rVO.setSituat(situat);
			
			int cnt = rDao.addResipe(rVO);
			req.setAttribute("ADDCNT", cnt);
			req.setAttribute("VIEW", "/fri/recipeAdd.fri");
//			req.setAttribute("isRedirect", true);
//			String rview = "/fri/recipeAdd.fri";
			
			if(cnt == 0) {
				return view;
			}
			
			// 파일 업로드 해주고....
			String savename = multi.getFilesystemName("thumb");
			if(savename == null) {
				req.setAttribute("ADDCNT", 0);
				return view;
			}
			
			cnt = rDao.addThumb(savename);
			if(cnt == 0) {
				req.setAttribute("ADDCNT", 0);
				return view;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		req.setAttribute("isRedirect", false);
		return view;
	}
	
}