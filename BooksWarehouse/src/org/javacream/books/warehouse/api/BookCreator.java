package org.javacream.books.warehouse.api;

import java.util.Map;

@FunctionalInterface
public interface BookCreator {

	Book create(String isbn, String title, double price, Map<String, Object> options);
}
