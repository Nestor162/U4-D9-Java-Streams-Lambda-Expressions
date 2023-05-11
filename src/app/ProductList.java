package app;

import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class ProductList {
	private List<Product> productList;

	public ProductList() {
		productList = new ArrayList<>();
	}

	public void addProduct(Product product) {
		productList.add(product);
	}

	public void removeProduct(Product product) {
		productList.remove(product);
	}

	public List<Product> getProductList() {
		return productList;
	}

	@Override
	public String toString() {
		return "ProductList: " + productList;
	}

}
