package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
	long id;
	String status;
	LocalDate orderDate;
	LocalDate deliverDate;
	List<Product> products;
	Customer customer;

	protected Order(String status, LocalDate orderDate, LocalDate deliverDate, List<Product> products,
			Customer customer) {

		this.id = generateId();
		this.status = status;
		this.orderDate = orderDate;
		this.deliverDate = deliverDate;
		this.products = products;
		this.customer = customer;
	}

	private static long generateId() {
		Random rand = new Random();
		return rand.nextLong();
	}

}
