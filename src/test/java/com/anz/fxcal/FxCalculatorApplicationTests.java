package com.anz.fxcal;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anz.fxcal.bean.Response;
import com.anz.fxcal.service.AppService;

@SpringBootTest
class FxCalculatorApplicationTests {

	@Autowired
	private AppService AppService;
	
	@Test
	void contextLoads() {
		Assertions.assertEquals(0, 0);
	}
	
	@Test
	void fullResonse() {
		Response res = AppService.execute("AUD 100.00 in USD");
		Assertions.assertEquals(res.getFinalResponse(),"AUD 100.00 = USD 83.71");
	}
	

}
