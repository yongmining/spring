package com.greedy.section01.singleton.xmlconfg;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private final List<Product> items;
	
	public ShoppingCart() {
		this.items = new ArrayList<>();
	}
	
	public void addItem(Product item) {
		items.add(item);
	}
	
	public List<Product> getItems() {
		return items;
	}
}
