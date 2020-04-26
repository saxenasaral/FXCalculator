package com.anz.fxcal.bean;

import org.springframework.util.StringUtils;

import com.anz.fxcal.config.AppConstants;
import com.anz.fxcal.config.FxContext;

public class Response {

	private Double finalAmount = 0.0;
	private String finalResponse = "";
	private boolean isSuccess = false;

	public Double getAmount() {
		return finalAmount;
	}

	public void setAmount(Double amount) {
		this.finalAmount = amount;
	}

	public String getFinalResponse() {
		if(StringUtils.isEmpty(finalResponse))
			createFinalResponse();
		return finalResponse;
	}

	public void setFinalResponse(String finalResponse) {
		this.finalResponse = finalResponse;
	}

	public void createFinalResponse() {
		String base = FxContext.getInstance().getBaseCurrency().getName();
		String term = FxContext.getInstance().getTermsCurrency().getName();
				
		if (isSuccess) {
			String precisionTerm = "%."+FxContext.getInstance().getTermsCurrency().getDecimalPlaces()+"f";
			String precisionBase = "%."+FxContext.getInstance().getBaseCurrency().getDecimalPlaces()+"f";
			String precTarget = String.format(precisionTerm, finalAmount);
			String precBase = String.format(precisionBase, FxContext.getInstance().getAmount());
			finalResponse = base + " " + precBase + " = " + term + " " + precTarget;
		} else {
			finalResponse = AppConstants.RESPONSE_FAILURE + base + "/" + term;
		}

	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
}
