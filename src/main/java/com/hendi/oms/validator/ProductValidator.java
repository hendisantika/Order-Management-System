package com.hendi.oms.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.hendi.oms.model.Product;

public class ProductValidator implements Validator{

	@Override
	public boolean supports(Class clazz) {
		//just validate the Product instances
		return Product.class.isAssignableFrom(clazz);

	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productName",
			"required.productName", "Product name is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "productDescription",
				"required.productDescription", "Product Description is required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "unitPrice",
				"required.unitPrice", "Unit Price is required.");
		
	}
	
}