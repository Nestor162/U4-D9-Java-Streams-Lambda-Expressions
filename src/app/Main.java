package app;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import entities.Customer;
import entities.Order;
import entities.Product;

public class Main {

	public static void main(String[] args) {

		// Creo le istanze per i prodotti
		Product p1 = new Product("Laptop Honor X14", "Electronics", 500);
		Product p2 = new Product("Apple iPad", "Electronics", 270);
		Product p3 = new Product("Mistborn: The final empire", "Books", 23);
		Product p4 = new Product("Chainsaw Man vol. 1", "Books", 6);
		Product p5 = new Product("Baby wipes", "Baby", 17);
		Product p6 = new Product("Toy Car", "Boys", 6);
		Product p7 = new Product("La Divina Commedia", "Books", 110);

		List<Product> generalList = new ArrayList<>();
		generalList.add(p1);
		generalList.add(p2);
		generalList.add(p3);
		generalList.add(p4);
		generalList.add(p5);
		generalList.add(p6);
		generalList.add(p7);

		List<Product> list1 = new ArrayList<>();
		list1.add(p5);
		list1.add(p6);
		list1.add(p7);

		List<Product> list2 = new ArrayList<>();
		list2.add(p1);
		list2.add(p3);
		list2.add(p7);

		List<Product> list3 = new ArrayList<>();
		list3.add(p5);

		Customer customer1 = new Customer("Mario", 2);
		Customer customer2 = new Customer("Chiara", 1);
		Customer customer3 = new Customer("Giovanni", 2);

		Order order1 = new Order("pending", list1, customer1);
		Order order2 = new Order("pending", list2, customer2);
		Order order3 = new Order("pending", list3, customer3);

		List<Order> orderList = new ArrayList<>();
		orderList.add(order1);
		orderList.add(order2);
		orderList.add(order3);

		exercise1(generalList);
		exercise2(orderList);
		exercise3(generalList);
		exercise4(orderList);

	}

	public static void exercise1(List<Product> generalList) {

		Predicate<Product> isBookAndExpensive = p -> p.getCategory()
				.equals("Books") && p.getPrice() > 100;

		List<Product> filteredProducts = generalList.stream()

				.filter(isBookAndExpensive).toList();

		System.out.println(
				"Prodotti nella categoria Libri che costano piú di 100 euro:"
						+ System.lineSeparator() + filteredProducts
						+ System.lineSeparator());
	}

	public static void exercise2(List<Order> orderList) {

		Predicate<Order> isProductInBabyCategory = o -> o.getProducts().stream()
				.anyMatch(product -> product.getCategory().equals("Baby"));

		List<Order> orderBabyCategory = orderList.stream()
				.filter(isProductInBabyCategory).toList();

		System.out.println("Ordini contenenti prodotti nella categoria Baby:"
				+ System.lineSeparator() + orderBabyCategory.toString()
				+ System.lineSeparator());
	}

	public static void exercise3(List<Product> generalList) {
		List<Product> boyProducts = generalList.stream()
				.filter(prod -> prod.getCategory().equals("Boys")).toList();

		List<Double> boyDiscountedPrices = boyProducts.stream().map(
				product -> product.getPrice() - (product.getPrice() * 10 / 100))
				.toList();

		for (Product bProduct : boyProducts) {
			boyDiscountedPrices
					.forEach(newPrice -> bProduct.setPrice(newPrice));

		}

		System.out.println("Prodotti categoria Boys con prezzo scontato: "
				+ System.lineSeparator() + boyProducts
				+ System.lineSeparator());
	}

	private static void exercise4(List<Order> orderList) {

		LocalDate startDate = LocalDate.of(2023, 5, 03);
		LocalDate endDate = LocalDate.of(2023, 5, 20);

		Predicate<Order> isTier2Customer = order -> order.getCustomer()
				.getTier() == 2;

		Predicate<Order> isOrderBetweenDates = order -> order.getOrderDate()
				.isAfter(startDate) && order.getOrderDate().isBefore(endDate);

		List<Order> Tier2ProductsDates = orderList.stream()
				.filter(isTier2Customer.and(isOrderBetweenDates)).toList();

		System.out.println("I prodotti che soddisfano i requisiti sono: "
				+ System.lineSeparator() + Tier2ProductsDates);
	}

}
