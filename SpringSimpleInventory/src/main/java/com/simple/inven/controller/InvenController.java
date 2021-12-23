package com.simple.inven.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.service.IService;
import com.simple.inven.service.ServiceResult;

@Controller
public class InvenController extends BaseController {

	@Autowired
	@Qualifier("simpleService")
	IService service;
	
	// 아이템 판매 시도
	@RequestMapping("sell.do")
	public RedirectView sellDo(
			  @RequestParam("sell_item_uid") int inven_item_uid,
			  @RequestParam("sell_item_count") int item_count,
			  HttpServletRequest request, 
			  RedirectAttributes redirectAttributes)
	{
		if (!isLogin(request)) {
			redirectAttributes.addFlashAttribute("serviceResult", new ServiceResult(false, "로그인을 먼저 해주세요"));
			return redirectView;
		}
		
		int user_uid = getUser_Uid(request);
		ServiceResult serviceResult = service.sellItem(user_uid, inven_item_uid, item_count);
		redirectAttributes.addFlashAttribute("serviceResult", serviceResult);
		return redirectView;
	}
}
