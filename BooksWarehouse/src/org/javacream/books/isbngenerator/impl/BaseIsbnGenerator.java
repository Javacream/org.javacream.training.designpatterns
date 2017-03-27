package org.javacream.books.isbngenerator.impl;

import org.javacream.books.isbngenerator.api.IsbnGenerator;

public abstract class BaseIsbnGenerator implements IsbnGenerator {
	private String prefix;
	private String countryCode;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

}
