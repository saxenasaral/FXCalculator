package com.anz.fxcal.bean;

public final class Currency {

	private final String name;
	private final int decimalPlaces;
	private Double amount;

	public Currency(String name, int decimalPlaces) {
		super();
		this.name = name;
		this.decimalPlaces = decimalPlaces;
	}

	public String getName() {
		return name;
	}

	public int getDecimalPlaces() {
		return decimalPlaces;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + decimalPlaces;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Currency other = (Currency) obj;
		if (decimalPlaces != other.decimalPlaces)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Currency [name=" + name + ", decimalPlaces=" + decimalPlaces + "]";
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

}
