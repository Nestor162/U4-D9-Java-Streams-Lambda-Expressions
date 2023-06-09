package entities;

import java.util.Random;

public class Customer {
	Long id;
	String name;
	int tier;

	public Customer(String name, int tier) {

		this.id = generateId();
		this.name = name;
		this.tier = tier;
	}

	private static long generateId() {
		Random rand = new Random();
		return rand.nextLong();
	}

	@Override
	public String toString() {
		return name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

}
