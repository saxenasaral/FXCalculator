package com.anz.fxcal.config;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.anz.fxcal.bean.Currency;
import com.anz.fxcal.bean.CurrencyMatrix;

public class FxContext {

	private static final Logger LOG = LoggerFactory.getLogger(FxContext.class);

	public static FxContext instance = null;
	private Map<String, Currency> currencyMap = new HashMap<String, Currency>();
	private Map<Currency, CurrencyMatrix> currencyMatrixMap = new HashMap<Currency, CurrencyMatrix>();
	private Map<String, Double> forexMap = new HashMap<String, Double>();
	private Currency baseCurrency;
	private Currency termsCurrency;
	private Double amount;

	private FxContext() {
		currencyMap.put(AppConstants.CUR_DIRECT, new Currency(AppConstants.CUR_DIRECT, 0));
		currencyMap.put(AppConstants.CUR_INVERSE, new Currency(AppConstants.CUR_INVERSE, 0));
		currencyMap.put(AppConstants.CUR_SAME, new Currency(AppConstants.CUR_SAME, 0));
	}

	public static FxContext getInstance() {
		if (instance == null)
			instance = new FxContext();
		return instance;
	}

	public Map<String, Currency> getCurrencyMap() {
		return Collections.unmodifiableMap(currencyMap);
	}

	public Map<Currency, CurrencyMatrix> getCurrencyMatrixMap() {
		return Collections.unmodifiableMap(currencyMatrixMap);
	}

	public Map<String, Double> getForexMap() {
		return Collections.unmodifiableMap(forexMap);
	}

	public void addCurrencyMap(String currName) {
		String cur = currName.toUpperCase();
		Currency currency = new Currency(cur, (cur == "JPY") ? 0 : 2);
		currencyMap.put(cur, currency);
	}

	public void addCurrencyMatrixMap(Currency currName, CurrencyMatrix currencyMatrix) {
		currencyMatrixMap.put(currName, currencyMatrix);
	}

	public void addForexMap(Map<String, Double> forexMap) {
		this.forexMap.putAll(forexMap);
	}

	public Currency getBaseCurrency() {
		if (baseCurrency == null)
			return new Currency("", 0);
		return baseCurrency;
	}

	public Currency getTermsCurrency() {
		if (termsCurrency == null)
			return new Currency("", 0);
		return termsCurrency;
	}

	public void setBaseCurrency(Currency baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public void setTermsCurrency(Currency termsCurrency) {
		this.termsCurrency = termsCurrency;
	}

	public Double getAmount() {
		if (amount == null)
			return 0.0;
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public void clearContext() {
		baseCurrency = null;
		termsCurrency = null;
		amount = null;

	}

	public void printCurrencyMatrix() {
		for (Map.Entry<Currency, CurrencyMatrix> entry : currencyMatrixMap.entrySet()) {
			LOG.debug("Currency matric for " + entry.getKey().getName());
			for (Map.Entry<Currency, Currency> entryInner : entry.getValue().getTermMatrixMap().entrySet()) {
				LOG.debug(entry.getKey().getName()+" - "+entryInner.getKey().getName() + " : " + entryInner.getValue().getName());
			}
		}
	}

}
