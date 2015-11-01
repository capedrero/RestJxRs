package com.edreams.main.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class DestinationDiscountReaderBean {

	private List<DestinationDiscountBean> listObjects;

	@JsonProperty("results")
	public List<DestinationDiscountBean> getListObjects() {
		return listObjects;
	}

}
