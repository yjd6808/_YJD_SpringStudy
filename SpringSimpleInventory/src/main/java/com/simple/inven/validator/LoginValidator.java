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
		
		// �� ValidationUtils Ŭ������ �Ⱦ��� �Ʒ��� ���� ��� �Ἥ �Է��� ����� ����� Ȯ���ؾ���
		
		AccountDto accountDto = (AccountDto)target; 
		String userId = accountDto.getUserId();
		String userPass = accountDto.getUserPass();

		if (userId == null || userId == "" || userId.trim().isEmpty()) {
			errors.rejectValue("userId", "userId�� ����ֽ��ϴ�.");
		}
		
		if (userPass == null || userPass == "" || userPass.trim().isEmpty()) {
			errors.rejectValue("userPass", "userPass�� ����ֽ��ϴ�.");
		}
		
	}

}
