package com.edreams.main.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationDiscountBean {
	private String city;
	private Integer rateDiscount;
	
	@JsonProperty("city")
	public String getCity() {
		return city;
	}
	@JsonProperty("discount")
	public Integer getRateDiscount() {
		return rateDiscount;
	}
	
	/*@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((rateDiscount == null) ? 0 : rateDiscount.hashCode());
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
		DestinationDiscountBean other = (DestinationDiscountBean) obj;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (rateDiscount == null) {
			if (other.rateDiscount != null)
				return false;
		} else if (!rateDiscount.equals(other.rateDiscount))
			return false;
		return true;
	}*/
	
	

}
