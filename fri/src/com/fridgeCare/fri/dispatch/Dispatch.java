package com.fridgeCare.fri.dispatch;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.fridgeCare.fri.controller.Caller;

public class Dispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Caller> map;
	
	public void init(ServletConfig config) throws ServletException {
		/*
			이 함수는 서버가 기동된 후
			.fri로 끝나는 요청이 왔을 경우 최초 딱 한번만 실행되는 함수
			최초롤 이 서블릿이 시작되면 준비된 properties 파일을 읽어서
			이것을 이용해서 실제 실행가능한 클래스로 요청 내요과 클래스객체를 매핑을 해놔야 한다.
			
			파일에서 직접 읽어서 Map으로 만들어야 하므로
			Properties라는 클래스를 이용해서 작업하자.
		 */
		Properties prop = new Properties();
		FileInputStream fin = null;
		try {
			// 먼저 읽어올 파일의 경로를 알아낸다.
			String spath = this.getClass().getResource("").getPath();
//			System.out.println("### dispatch spath : " + spath);
			
			fin = new FileInputStream(spath + "../resources/Project.properties");
			prop.load(fin);
//			System.out.println("prop - /main.cls : " + prop.get("/main.cls"));
		} catch(Exception e) {
			System.out.println("##### .fri init 실패 #####");
//			e.printStackTrace();
		} finally {
			try {
				fin.close();
			} catch(Exception e) {}
		}
		
		// 문자열로 만들어진 맵을 이용해서 실제 실행가능한 map을 초기화 해주자.
		map = new HashMap<String, Caller>();
		
		// 먼저 키값만 뽑아온다.
		Set<Object> set = prop.keySet();
		
		ArrayList<Object> list = new ArrayList<Object>(set);
		for(Object o : list) {
			// 키값을 문자열로 강제 형변환
			String skey = (String) o;
			// 키값을 이용해서 경로 뽑아오고
			String classPath = (String) prop.get(skey);
			
			// 실제 실행가능한 클래스로 변환해준다.
			try {
				Class<?> tmp = Class.forName(classPath);
				Caller cls = (Caller) tmp.newInstance();
				
				// map에 추가해준다.
				map.put(skey, cls);
			} catch(Exception e) {}
		}
	}
	
	// 실제 요청 내용에 맞는 처리 담당하는 함수
	public void service(HttpServletRequest req, HttpServletResponse resp) 
										throws ServletException, IOException {
		// 1.	요청내용을 알아낸다. <== .fri 로 끝나는 모든 요청이 이 함수에서 실행되므로 
		//							요청내용에 맞는 실행을 찾아서 해줘야 하겠다.
		String full = req.getRequestURI();
		// 2. full <== /fridge/xxxxx/xxxx.cls
		String realPath = full.substring(full.indexOf('/', 1));
		
		// 3. 요청 내용에 맞는 실제 실행할 클래스를 가져온다.
		Caller cls = map.get(realPath);
		
		Boolean bool = null;
		/*
			bool == null	: 비동기 통신 처리
			bool == false	: forward
			bool == true	: redirect
		 */
		
		req.setAttribute("isRedirect", false);
		String view = cls.exec(req, resp);
		try {
			bool = (Boolean) req.getAttribute("isRedirect");
		} catch(Exception e) {}
		
		if(bool == null) {
			// 이경우는 비동기 통신이므로 반환되는 문자열을 응답문서로 만들어준다.
			PrintWriter pw = resp.getWriter();
			pw.print(view);
		} else if(bool) {
			// 리다이렉트 시켜야 하는 경우
			resp.sendRedirect(view);
		} else if(!bool) {
			String prefix = "/WEB-INF/views/com/fridgeCare/fri/";
			String surffix = ".jsp";
			RequestDispatcher rd = req.getRequestDispatcher(prefix + view + surffix);
			rd.forward(req, resp);
		}
	}
}