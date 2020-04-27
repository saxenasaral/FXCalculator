package com.anz.fxcal.validation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InputValidationTest {

	@Autowired
	private InputValidation inputValidation;
	
	@Test
	public void testValidate() {
		boolean isValid = inputValidation.validate("AUD 100.00 in USD");
		Assertions.assertEquals(isValid,true);
	}
}
