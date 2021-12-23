package com.simple.inven.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.dto.InvenDto;
import com.simple.inven.service.IService;
import com.simple.inven.service.ServiceResult;

@Controller
public class ShopController extends BaseController {

	@Autowired
	@Qualifier("simpleService")
	IService service;
	
	// 아이템 구매 시도
	@RequestMapping("buy.do")
	public RedirectView buy(@RequestParam("buy_item_uid") int item_uid, 
					  @RequestParam("buy_item_count") int buyCount,
					  HttpServletRequest request,
					  RedirectAttributes reidrectAttributes) {
		if (!isLogin(request)) {
			reidrectAttributes.addFlashAttribute("serviceResult", new ServiceResult(false, "로그인을 해주세요."));
			return redirectView;
		}
		
		int user_uid = getUser_Uid(request);
		ServiceResult serviceResult = service.buyItem(user_uid, item_uid, buyCount);
		reidrectAttributes.addFlashAttribute("serviceResult", serviceResult);
		return redirectView;
	}
}
