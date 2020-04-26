package com.anz.fxcal.validation;

import org.springframework.stereotype.Component;

import com.anz.fxcal.bean.Currency;
import com.anz.fxcal.config.FxContext;

@Component
public class InputValidation {

	public void validate(String input) {
		String base = "";
		String term = "";
		try {
			String[] format = input.split(" ");

			if (format.length != 4)
				throw new RuntimeException();

			base = format[0].trim();
			term = format[3].trim();

			if (!FxContext.getInstance().getCurrencyMap().containsKey(base.toUpperCase())
					|| !FxContext.getInstance().getCurrencyMap().containsKey(term.toUpperCase())) {
				FxContext.getInstance().setBaseCurrency(new Currency(base, 0));
				FxContext.getInstance().setTermsCurrency(new Currency(term, 0));
				throw new RuntimeException();
			}

			double amount = Double.parseDouble(format[1].trim());
			FxContext.getInstance().setAmount(amount);

			FxContext.getInstance().setBaseCurrency(FxContext.getInstance().getCurrencyMap().get(base.toUpperCase()));
			FxContext.getInstance().setTermsCurrency(FxContext.getInstance().getCurrencyMap().get(term.toUpperCase()));
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
