package com.anz.fxcal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anz.fxcal.bean.Response;
import com.anz.fxcal.validation.InputValidation;

@Component
public class AppService {
	
	@Autowired
	private InputValidation inputValidation;
	
	@Autowired
	private ForexService forexService;

	public Response execute(String input) {
		
		inputValidation.validate(input);
		
		Response response = forexService.calculateForex();
		
		response.createFinalResponse();
		
		return response;
	}
}
