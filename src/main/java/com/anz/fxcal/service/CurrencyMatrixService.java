package com.anz.fxcal.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.anz.fxcal.bean.Currency;
import com.anz.fxcal.bean.CurrencyMatrix;
import com.anz.fxcal.config.AppConstants;
import com.anz.fxcal.config.FxContext;

@Component("currencyMatrixService")
public class CurrencyMatrixService {

	public void loadCurrencyMatrix() {
		Map<String, Currency> currencyMap = FxContext.getInstance().getCurrencyMap();
		for (String currencyString : AppConstants.CURRENCIES) {
			Map<Currency, Currency> termMatrixMap = new HashMap<Currency, Currency>();
			CurrencyMatrix currencyMatrix = new CurrencyMatrix();
			currencyMatrix.setCurrency(currencyMap.get(currencyString));
			switch (currencyMap.get(currencyString).getName()) {
			case AppConstants.CUR_AUD:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_DIRECT));
				break;
			case AppConstants.CUR_CAD:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_DIRECT));

				break;
			case AppConstants.CUR_CNY:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_DIRECT));

				break;
			case AppConstants.CUR_CZK:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_EUR));

				break;
			case AppConstants.CUR_DKK:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_EUR));

				break;
			case AppConstants.CUR_EUR:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_DIRECT));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_DIRECT));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_DIRECT));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_DIRECT));

				break;
			case AppConstants.CUR_GBP:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_DIRECT));

				break;
			case AppConstants.CUR_JPY:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_INVERSE));

				break;
			case AppConstants.CUR_NOK:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_EUR));

				break;
			case AppConstants.CUR_NZD:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_USD));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_SAME));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_DIRECT));

				break;
			case AppConstants.CUR_USD:
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_AUD), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CAD), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CNY), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_CZK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_DKK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_EUR), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_GBP), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_JPY), currencyMap.get(AppConstants.CUR_DIRECT));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NOK), currencyMap.get(AppConstants.CUR_EUR));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_NZD), currencyMap.get(AppConstants.CUR_INVERSE));
				termMatrixMap.put(currencyMap.get(AppConstants.CUR_USD), currencyMap.get(AppConstants.CUR_SAME));

				break;
			}
			currencyMatrix.setTermMatrixMap(termMatrixMap);
			FxContext.getInstance().addCurrencyMatrixMap(currencyMap.get(currencyString), currencyMatrix);
		}
	}
}
