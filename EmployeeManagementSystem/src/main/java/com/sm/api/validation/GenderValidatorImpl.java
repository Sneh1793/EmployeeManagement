package com.sm.api.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GenderValidatorImpl implements 
ConstraintValidator<GenderValidator, Character> {

	@Override
	public boolean isValid(Character value, ConstraintValidatorContext context) {
		// comparing the input with valid arguments 
		return(value!= null && (value.compareTo('M')==0 || value.compareTo('F')==0));
	}

}
