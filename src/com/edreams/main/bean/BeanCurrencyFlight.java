package com.edreams.main.bean;

public class BeanCurrencyFlight {
	private String ccyOrigin;
	private String ccyDest;
	private Double rate;

	public BeanCurrencyFlight() {
		super();
	}

	public String getCcyOrigin() {
		return ccyOrigin;
	}

	public void setCcyOrigin(String ccyOrigin) {
		this.ccyOrigin = ccyOrigin;
	}

	public String getCcyDest() {
		return ccyDest;
	}

	public void setCcyDest(String ccyDest) {
		this.ccyDest = ccyDest;
	}

	public Double getRate() {
		return rate;
	}

	public void setRate(Double rate) {
		this.rate = rate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ccyDest == null) ? 0 : ccyDest.hashCode());
		result = prime * result + ((ccyOrigin == null) ? 0 : ccyOrigin.hashCode());
		result = prime * result + ((rate == null) ? 0 : rate.hashCode());
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
		BeanCurrencyFlight other = (BeanCurrencyFlight) obj;
		if (ccyDest == null) {
			if (other.ccyDest != null)
				return false;
		} else if (!ccyDest.equals(other.ccyDest))
			return false;
		if (ccyOrigin == null) {
			if (other.ccyOrigin != null)
				return false;
		} else if (!ccyOrigin.equals(other.ccyOrigin))
			return false;
		if (rate == null) {
			if (other.rate != null)
				return false;
		} else if (!rate.equals(other.rate))
			return false;
		return true;
	}
	

}
