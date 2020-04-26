package com.anz.fxcal.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anz.fxcal.service.CurrencyMatrixService;
import com.anz.fxcal.service.CurrencyService;
import com.anz.fxcal.service.ForexService;

@Component
public class AppInitializator {

	private static final Logger LOG = LoggerFactory.getLogger(AppInitializator.class);
	
	@Autowired
	private CurrencyService currencyService;
	
	@Autowired
	private CurrencyMatrixService currencyMatrixService;
	
	@Autowired
	private ForexService forexService;
	 
    @PostConstruct
    private void init() {
    	LOG.info("AppInitializator initialization logic ...");
    	LOG.info("Load Currencies");
    	currencyService.loadCurrency();
    	LOG.info("FxContext.getInstance().getCurrencyMap() "+FxContext.getInstance().getCurrencyMap().toString());
    	LOG.info("load currency matrix and Forex rates");
    	currencyMatrixService.loadCurrencyMatrix();
    	FxContext.getInstance().printCurrencyMatrix();
    	forexService.loadForexMap();
    	LOG.info("FxContext.getInstance().getForexMap() "+FxContext.getInstance().getForexMap().toString());
    }
}
