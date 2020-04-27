package com.anz.fxcal.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.anz.fxcal.config.FxContext;

@SpringBootTest
public class ForexServiceTest {

	@Autowired
	private ForexService forexService;

	@Test
	void TestCalculateCrossOver() {
		double am = 100.00;
		double finalAm = forexService.calculateCrossOver(FxContext.getInstance().getCurrencyMap().get("AUD"),
				FxContext.getInstance().getCurrencyMap().get("DKK"), am);
		Assertions.assertEquals(Double.valueOf(String.format("%.2f", finalAm)), 505.76);
	}

}
