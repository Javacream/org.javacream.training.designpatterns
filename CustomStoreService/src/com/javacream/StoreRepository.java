package com.javacream;

import java.util.Random;

public abstract class StoreRepository {
	private static Random random = new Random(System.currentTimeMillis());
	public static Response read(Request request){
		return new Response(random.nextInt(100), System.currentTimeMillis(), request.getCatalog(), request.getItemId());
	}
	
}
