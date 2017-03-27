package org.javacream.books.isbngenerator.impl;

public class StaticCounterIsbnGenerator extends BaseIsbnGenerator {
	private static int counter = 0;
	
	@Override
	public String next(){
		return getPrefix() + counter++ + getCountryCode();
	}
}
