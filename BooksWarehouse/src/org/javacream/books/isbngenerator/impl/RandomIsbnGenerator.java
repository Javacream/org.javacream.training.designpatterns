package org.javacream.books.isbngenerator.impl;

public class RandomIsbnGenerator extends BaseIsbnGenerator {

	/* (non-Javadoc)
	 * @see org.javacream.books.isbngenerator.impl.IsbnGenerator#next()
	 */
	@Override
	public String next(){
		return getPrefix() + Math.random() + getCountryCode();
	}
}
