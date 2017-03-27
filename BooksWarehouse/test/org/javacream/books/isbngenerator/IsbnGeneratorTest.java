package org.javacream.books.isbngenerator;

import org.javacream.books.isbngenerator.api.IsbnGenerator;
import org.javacream.books.isbngenerator.impl.RandomIsbnGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IsbnGeneratorTest {

	private IsbnGenerator isbnGenerator;

	@Before
	public void setUp() {
		isbnGenerator = new RandomIsbnGenerator();
	}

	@Test
	public void isbnIsGenerated() {
		Assert.assertNotNull(isbnGenerator.next());
	}
	@Test
	public void isbnIsUnique() {
		String isbn1 = isbnGenerator.next();
		String isbn2 = isbnGenerator.next();
		Assert.assertNotEquals(isbn1,  isbn2);
		
	}
}
