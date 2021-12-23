package com.jdyun.example13_mvc.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/validate")
public class ValidateController {
	
	
	@RequestMapping("/form")
	public String form() {
		return "validate/form";
	}
	
	@RequestMapping("/check")
	public String create(ValidateClass student, BindingResult result) {
		String page = "validate/success";
		
		ValidateClassValidator validator = new ValidateClassValidator();
		validator.validate(student, result);

		
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
			
			page = "validate/form";
		}
		
		return page;
	}
}
