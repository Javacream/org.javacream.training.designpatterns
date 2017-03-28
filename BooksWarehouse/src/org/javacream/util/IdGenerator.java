package org.javacream.util;

import java.util.Random;

public class IdGenerator {

	private Random random;

	{
		random = new Random(this.hashCode() + System.currentTimeMillis());
	}

	public int next() {
		return Math.abs(random.nextInt());
	}
}
