package com.demo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidation.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME) // retain this annotation in java class file, process it at runtime
public @interface CourseCode {

	// define attribute
	public String value() default "LUV";

	// error message
	public String message() default "must be start with LUV";

	// defind default groups , can group related contraints
	public Class<?>[] groups() default {};

	// define default payloads -- provide custom details about validation failure
	// (error code, severity level)
	public Class<? extends Payload>[] payload() default {};

}
