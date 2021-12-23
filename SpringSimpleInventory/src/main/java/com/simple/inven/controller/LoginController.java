package com.simple.inven.controller;

import java.util.HashMap;


import java.util.function.Consumer;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.simple.inven.dto.AccountDto;
import com.simple.inven.service.IService;
import com.simple.inven.service.ServiceResult;
import com.simple.inven.validator.LoginValidator;

@Controller
public class LoginController extends BaseController {
	
	@Autowired
	@Qualifier("simpleService")
	IService service;
	
	Validator validator;
	
	
	// �α��� �õ�
	@RequestMapping("login.do")
	public RedirectView loginDo(AccountDto inputDto, 
						  BindingResult inputDtoValidateResult, 
						  HttpServletRequest request, 
						  RedirectAttributes reidrectAttributes) {
		
		validator = new LoginValidator();
		validator.validate(inputDto, inputDtoValidateResult);
 
		// ���̵� �Ǵ� ��й�ȣ�� ��Ȯ�� �Է� �ȵ� ���
		if (inputDtoValidateResult.hasErrors()) {
			String message = "";
			
			FieldError userIdError = inputDtoValidateResult.getFieldError("userId");
			FieldError userPassError = inputDtoValidateResult.getFieldError("userPass");
			
			if (userIdError != null) {
				message += userIdError;
			}
			
			if (userPassError != null) {
				message += userPassError;
			}
			
			reidrectAttributes.addFlashAttribute("serviceResult", new ServiceResult(false, message));
			return redirectView;
			
		}
		
		ServiceResult serviceResult = service.login(inputDto);
		
		// �α��ο� ������ ��� �κ��丮 ��� �̵�
		if (serviceResult.isSuccess()) {
			Object user_uid = serviceResult.getData();
			request.getSession().setAttribute("user_uid", user_uid);
			reidrectAttributes.addFlashAttribute("serviceResult", serviceResult);
			return redirectView;
		}
		
		reidrectAttributes.addFlashAttribute("serviceResult", serviceResult);
		return redirectView;
	}
}
