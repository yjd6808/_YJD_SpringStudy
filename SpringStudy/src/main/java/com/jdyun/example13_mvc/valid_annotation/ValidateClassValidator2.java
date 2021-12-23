package com.jdyun.example13_mvc.valid_annotation;

import java.util.*;

import org.springframework.validation.*;

// ValidateClass의 Validator이다.
public class ValidateClassValidator2 implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ValidateClassValidator2.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		System.out.println("@@@### validate()");
		ValidateClass2 validateClass = (ValidateClass2)target;
		String name = validateClass.getName();
		String pass = validateClass.getPass();
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "trouble");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "trouble");
		
		// ValidationUtils.rejectIfEmptyOrWhitespace 이게 더 편하다.
//		if (id == "" || id.trim().isEmpty()) {
//			System.out.println("id is null or empty");
//			errors.rejectValue("name", "trouble");
//		}
		
//		if (pass == "" || pass.trim().isEmpty()) {
//			System.out.println("pass is null or empty");
//			errors.rejectValue("pass", "trouble");
//		}
	}
}


