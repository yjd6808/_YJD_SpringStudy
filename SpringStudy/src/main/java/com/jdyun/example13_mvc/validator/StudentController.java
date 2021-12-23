package com.jdyun.example13_mvc.validator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/studentForm")
	public String studentForm() {
		return "createPage";
	}
	
	@RequestMapping("/student/create")
	public String studentCreate(Student student, BindingResult result){
		String page="createDonePage";
		
		
		StudentValidator validator = new StudentValidator();
		validator.validate(student, result);
		
		if (result.hasErrors()) {
			System.out.println("@@@### getFieldError id ====>  "+result.getFieldError("id"));
			System.out.println("@@@### getFieldError pw ====>  "+result.getFieldError("pw"));
			page = "createPage";
		}
		return page;
	}
	
}
