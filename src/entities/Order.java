package entities;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class Order {
	private long id;
	private String status;
	private LocalDate orderDate;
	private LocalDate deliverDate;
	private List<Product> products;
	private Customer customer;

	public Order(String status, List<Product> products, Customer customer) {

		this.id = generateId();
		this.status = status;
		this.orderDate = LocalDate.now();
		this.deliverDate = LocalDate.now().plusDays(7);
		this.products = products;
		this.customer = customer;
	}

	private static long generateId() {
		Random rand = new Random();
		return rand.nextLong();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public LocalDate getDeliverDate() {
		return deliverDate;
	}

	public void setDeliverDate(LocalDate deliverDate) {
		this.deliverDate = deliverDate;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
