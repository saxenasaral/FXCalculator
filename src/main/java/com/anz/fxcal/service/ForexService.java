package com.anz.fxcal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.anz.fxcal.bean.Currency;
import com.anz.fxcal.bean.Response;
import com.anz.fxcal.config.AppConstants;
import com.anz.fxcal.config.FxContext;

@Component("forexService")
public class ForexService {

	public void loadForexMap() {
		Map<String, Double> forexMap = new HashMap<String, Double>();
		forexMap.put(AppConstants.CUR_AUD + AppConstants.CUR_USD, 0.8371);
		forexMap.put(AppConstants.CUR_CAD + AppConstants.CUR_USD, 0.8711);
		forexMap.put(AppConstants.CUR_USD + AppConstants.CUR_CNY, 6.1715);
		forexMap.put(AppConstants.CUR_EUR + AppConstants.CUR_USD, 1.2315);
		forexMap.put(AppConstants.CUR_GBP + AppConstants.CUR_USD, 1.5683);
		forexMap.put(AppConstants.CUR_NZD + AppConstants.CUR_USD, 0.7750);
		forexMap.put(AppConstants.CUR_USD + AppConstants.CUR_JPY, 119.95);
		forexMap.put(AppConstants.CUR_EUR + AppConstants.CUR_CZK, 27.6028);
		forexMap.put(AppConstants.CUR_EUR + AppConstants.CUR_DKK, 7.4405);
		forexMap.put(AppConstants.CUR_EUR + AppConstants.CUR_NOK, 8.6651);
		FxContext.getInstance().addForexMap(forexMap);
	}

	public Response calculateForex() {

		Currency baseCurrency = FxContext.getInstance().getBaseCurrency();
		Currency termCurrency = FxContext.getInstance().getTermsCurrency();
		double amount = FxContext.getInstance().getAmount();

		Response response = new Response();
		response.setAmount(calculateCrossOver(baseCurrency, termCurrency, amount));
		response.setSuccess(true);
		return response;
	}

	public double findAmount(String crossType, Currency baseCurrency, Currency termCurrency, double amount) {
		Map<String, Double> forexMap = FxContext.getInstance().getForexMap();
		double rate;
		if(forexMap.get(baseCurrency.getName() + termCurrency.getName()) != null)
			rate = forexMap.get(baseCurrency.getName() + termCurrency.getName());
		else
			rate = forexMap.get(termCurrency.getName() + baseCurrency.getName());
		double res = 0.0;
		if (crossType.equals(AppConstants.CUR_DIRECT)) {
			res = rate * amount;
		} else if (crossType.equals(AppConstants.CUR_INVERSE)) {
			double newRate = 1 / rate;
			res = newRate * amount;
		} else {
			res = amount;
		}
		return res;
	}

	public Double calculateCrossOver(Currency baseCurrency, Currency termCurrency, Double amount) {
		Currency cross = FxContext.getInstance().getCurrencyMatrixMap().get(baseCurrency).getTermMatrixMap()
				.get(termCurrency);
		if (!needCrossOver(cross)) {
			return findAmount(cross.getName(), baseCurrency, termCurrency, amount);
		}
		Double newAmount = calculateCrossOver(baseCurrency, cross, amount);
		newAmount = calculateCrossOver(cross, termCurrency, newAmount);

		return newAmount;
	}

	public boolean needCrossOver(Currency resolver) {
		if (resolver.getName().equals(AppConstants.CUR_INVERSE) || resolver.getName().equals(AppConstants.CUR_DIRECT)
				|| resolver.getName().equals(AppConstants.CUR_SAME))
			return false;
		return true;
	}
}
