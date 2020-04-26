package com.anz.fxcal.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.anz.fxcal.config.FxContext;

@SpringBootTest
public class ForexServiceTest {

	@InjectMocks
	private ForexService forexService;

	@Test
	void TestCalculateCrossOver() {
		double am = 100.00;
		double finalAm = forexService.calculateCrossOver(FxContext.getInstance().getCurrencyMap().get("AUD"),
				FxContext.getInstance().getCurrencyMap().get("DKK"), am);
		System.out.print(finalAm);
	}
}
