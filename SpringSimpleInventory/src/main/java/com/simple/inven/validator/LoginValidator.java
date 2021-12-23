package com.simple.inven.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.simple.inven.dto.AccountDto;

public class LoginValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return AccountDto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "trouble");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userPass", "trouble");
		
		// → ValidationUtils 클래스를 안쓰면 아래와 같이 길게 써서 입력이 제대로 됬는지 확인해야함
		
		AccountDto accountDto = (AccountDto)target; 
		String userId = accountDto.getUserId();
		String userPass = accountDto.getUserPass();

		if (userId == null || userId == "" || userId.trim().isEmpty()) {
			errors.rejectValue("userId", "userId가 비어있습니다.");
		}
		
		if (userPass == null || userPass == "" || userPass.trim().isEmpty()) {
			errors.rejectValue("userPass", "userPass가 비어있습니다.");
		}
		
	}

}
