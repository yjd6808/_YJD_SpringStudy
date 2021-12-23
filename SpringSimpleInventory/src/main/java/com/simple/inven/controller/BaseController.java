package com.simple.inven.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class BaseController {
	protected RedirectView redirectView = new RedirectView("view/result", false);
	
	protected boolean isLogin(HttpServletRequest request) {
		return request.getSession().getAttribute("user_uid") != null;
	}
	
	protected int getUser_Uid(HttpServletRequest request) {
		return (Integer)request.getSession().getAttribute("user_uid");
	}
}
