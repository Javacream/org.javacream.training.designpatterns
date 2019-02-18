package org.javacream.books.order.impl;

import org.javacream.books.order.api.Order;
import org.javacream.books.order.api.Order.OrderStatus;
import org.javacream.books.order.api.OrderService;
import org.javacream.books.warehouse.api.Book;
import org.javacream.books.warehouse.api.BookException;
import org.javacream.books.warehouse.api.BooksService;
import org.javacream.store.api.StoreService;
import org.javacream.util.IdGenerator;

public class SimpleOrderService implements OrderService {
	
	private BooksService booksService;
	private StoreService storeService;
	private IdGenerator idGenerator;
	public void setBooksService(BooksService booksService) {
		this.booksService = booksService;
	}
	public void setStoreService(StoreService storeService) {
		this.storeService = storeService;
	}
	public void setIdGenerator(IdGenerator idGenerator) {
		this.idGenerator = idGenerator;
	}
	/* (non-Javadoc)
	 * @see org.javacream.books.order.OrderService#order(java.lang.String, int)
	 */
	@Override
	public Order order(String isbn, int amount){
		long orderId = idGenerator.next();
		OrderStatus orderStatus;
		double totalPrice = 0.0;
		try{
			Book book = booksService.findBookByIsbn(isbn);
			totalPrice = book.getPrice() * amount;
			if (storeService.getStock("books", isbn) >= amount){
				orderStatus = OrderStatus.OK;
			}else{
				orderStatus = OrderStatus.PENDING;
			}
		}catch(BookException e){
			orderStatus = OrderStatus.UNACCEPTABLE;
		}
		
		return new Order(orderId, isbn, totalPrice, orderStatus, amount);
	}

}
