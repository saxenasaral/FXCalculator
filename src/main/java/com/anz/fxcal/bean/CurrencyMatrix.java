package com.anz.fxcal.bean;

import java.util.Map;

public class CurrencyMatrix {

	private Currency currency;
	private Map<Currency, Currency> termMatrixMap;

	public CurrencyMatrix() {

	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Map<Currency, Currency> getTermMatrixMap() {
		return termMatrixMap;
	}

	public void setTermMatrixMap(Map<Currency, Currency> termMatrixMap) {
		this.termMatrixMap = termMatrixMap;
	}

	@Override
	public String toString() {
		return "CurrencyMatrix [currency=" + currency + ", termMatrixMap=" + termMatrixMap + "]";
	}

}
