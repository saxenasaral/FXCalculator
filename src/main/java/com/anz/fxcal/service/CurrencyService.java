package com.anz.fxcal.service;

import org.springframework.stereotype.Component;

import com.anz.fxcal.config.AppConstants;
import com.anz.fxcal.config.FxContext;

@Component("currencyService")
public class CurrencyService {

	public void loadCurrency() {
		for (String currencyString : AppConstants.CURRENCIES) {
			FxContext.getInstance().addCurrencyMap(currencyString);
		}
	}
}
