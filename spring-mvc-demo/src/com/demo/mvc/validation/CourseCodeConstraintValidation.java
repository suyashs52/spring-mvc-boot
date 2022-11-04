package com.demo.mvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidation implements ConstraintValidator<CourseCode, String> {

	private String prefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		prefix = constraintAnnotation.value(); // access the attribute value
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext context) {

		return theCode != null && theCode.startsWith(prefix);
	}

}
