
package com.waiyanhtet.student.annotation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.util.StringUtils;

public class PhoneConstraint implements ConstraintValidator<Phone, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(StringUtils.hasLength(value)) {
			var pattern = "09(\\d{7,9})";
			if(value.matches(pattern)) {
				return true;
			}
		}
		return false;
	}
	
}
