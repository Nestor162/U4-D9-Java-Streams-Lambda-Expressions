package app;

import java.util.List;
import java.util.function.Predicate;

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

		// Creo una istanza di ProductList e aggiungo y prodotti creati precedentemente
		ProductList productList = new ProductList();
		productList.addProduct(p1);
		productList.addProduct(p2);
		productList.addProduct(p3);
		productList.addProduct(p4);
		productList.addProduct(p5);
		productList.addProduct(p6);
		productList.addProduct(p7);

		exercise1(productList);

	}

	public static void exercise1(ProductList productList) {

		Predicate<Product> isBookAndExpensive = p -> p.getCategory().equals("Books") && p.getPrice() > 100;

		List<Product> filteredProducts = productList.getProductList().stream()

				.filter(isBookAndExpensive).toList();

		System.out.println("Prodotti nella categoria Libri che costano piú di 100 euro: \n " + filteredProducts);
	}

}
