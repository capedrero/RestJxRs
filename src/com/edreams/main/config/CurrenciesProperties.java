package com.edreams.main.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(locations = "directions.properties", ignoreUnknownFields = false, prefix = "ccy")
public class CurrenciesProperties {
	private String url;
	private String rootName;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRootName() {
		return rootName;
	}
	public void setRootName(String rootName) {
		this.rootName = rootName;
	}
	@Override
	public String toString() {
		return "CurrenciesProperties [" + (url != null ? "url=" + url + ", " : "")
				+ (rootName != null ? "rootName=" + rootName : "") + "]";
	}
	
}
