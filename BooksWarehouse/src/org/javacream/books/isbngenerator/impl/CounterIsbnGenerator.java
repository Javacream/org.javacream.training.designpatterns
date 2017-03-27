package org.javacream.books.isbngenerator.impl;

public class CounterIsbnGenerator extends BaseIsbnGenerator {
	private int counter = 0;
	
	@Override
	public String next(){
		return getPrefix() + counter++ + getCountryCode();
	}
}
