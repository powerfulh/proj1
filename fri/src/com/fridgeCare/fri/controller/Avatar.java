package com.fridgeCare.fri.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/avatar/*")
public class Avatar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service(HttpServletRequest a , HttpServletResponse b) {
		String view = "/WEB-INF/resources/img/avatar/";
		String url = a.getRequestURI();
		url = url.substring(url.indexOf("/", 5)+1);
		view += url;
		RequestDispatcher rd = a.getRequestDispatcher(view);
		try {
			rd.forward(a, b);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}
}
