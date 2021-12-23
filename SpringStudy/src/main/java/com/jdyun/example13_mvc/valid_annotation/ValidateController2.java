package com.jdyun.example13_mvc.valid_annotation;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/valid_annotation")
public class ValidateController2 {
	
	
	@RequestMapping("/form")
	public String form() {
		return "valid_annotation/form";
	}
	
	@RequestMapping("/check")
	public String create(@Valid ValidateClass2 student, BindingResult result) {
		String page = "valid_annotation/success";
		
		// @Valid 어노테이션이 자동으로 바인딩 해줌
		// ValidateClassValidator validator = new ValidateClassValidator();
		// validator.validate(student, result);

		
		if (result.hasErrors()) {
			FieldError nameError = result.getFieldError("name");
			FieldError passError = result.getFieldError("pass");
			
			if (nameError == null) {
				System.out.println("@@@### getFieldError name ===> " + "오류없음");				
			} else {
				System.out.println("@@@### getFieldError name ===> " + nameError);
			}
			
			if (passError == null) {
				System.out.println("@@@### getFieldError pass ===> " + "오류없음");				
			} else {
				System.out.println("@@@### getFieldError pass ===> " + passError);
			}
			
			page = "valid_annotation/form";
		}
		
		return page;
	}
	
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ValidateClassValidator2());
	}
	
}
