package com.simple.inven.controller;

import java.util.Map;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.dto.InvenDto;
import com.simple.inven.service.IService;
import com.simple.inven.service.ServiceResult;

@Controller
@RequestMapping("/view")
public class ViewController extends BaseController {
	
	@Autowired
	@Qualifier("simpleService")
	IService service;
	
	@RequestMapping("/login")
	public String loginView() {
		return "login_view";
	}
	
	@RequestMapping("/inventory")
	public String inventoryView(Model model,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (!isLogin(request)) {
			redirectAttributes.addFlashAttribute("serviceResult", new ServiceResult(false, "로그인을 먼저 해주세요."));
			return "redirect:result";
		}
		
		int user_uid = (Integer)request.getSession().getAttribute("user_uid");
		
		AccountDto accountDto = service.getAccount(user_uid);
		InvenDto invenDto = service.getInventory(user_uid);
		
		model.addAttribute("accountDto", accountDto);
		model.addAttribute("invenDto", invenDto);
		model.addAttribute("items", service.listInvenItems(invenDto.getU_id()));
		return "inventory_view";
	}
	
	@RequestMapping("/shop")
	public String shopView(Model model,HttpServletRequest request, RedirectAttributes redirectAttributes) {
		if (!isLogin(request)) {
			redirectAttributes.addFlashAttribute("serviceResult", new ServiceResult(false, "로그인을 먼저 해주세요."));
			return "redirect:result";
		}
		
		int user_uid = (Integer)request.getSession().getAttribute("user_uid");
		
		AccountDto accountDto = service.getAccount(user_uid);
		InvenDto invenDto = service.getInventory(user_uid);
		
		model.addAttribute("accountDto", accountDto);
		model.addAttribute("invenDto", invenDto);
		model.addAttribute("items", service.listShopItems());
		return "shop_view";
	}
	
	@RequestMapping("/result")
	public String resultView(Model model) {
		
		Map<String, Object> modelMap = model.asMap();
		
		if (!modelMap.containsKey("serviceResult")) {
			model.addAttribute("serviceResult", new ServiceResult(false, "요청에 대한 결과 메시지가 업습니다 ㄷㄷ"));
			return "result_view";
		}
		
		ServiceResult serviceResult = (ServiceResult)modelMap.get("serviceResult");
		model.addAttribute("serviceResult", serviceResult);
		return "result_view";
	}
}
