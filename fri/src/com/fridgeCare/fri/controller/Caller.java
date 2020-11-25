package com.fridgeCare.fri.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Caller {
	String exec(HttpServletRequest req, HttpServletResponse resp);
}
