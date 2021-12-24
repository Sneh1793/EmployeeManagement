package com.sm.api.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;



@Target( { ElementType.METHOD, ElementType.FIELD })
@Documented
@Constraint(validatedBy = GenderValidatorImpl.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface GenderValidator {
	 String message() default "Invalid gender";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};
}
