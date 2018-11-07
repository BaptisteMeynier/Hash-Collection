package com.java.optim.hash.collection;

import java.util.Date;
import java.util.List;

public class BeanWithoutHash {

	private int price;
	private boolean available;
	private String name;
	private Date creation;
	private List<String> owner;
	
	public BeanWithoutHash() {}
	
	public BeanWithoutHash(int price, boolean available, String name, Date creation, List<String> owner) {
		super();
		this.price = price;
		this.available = available;
		this.name = name;
		this.creation = creation;
		this.owner = owner;
	}

	public boolean isAvailable() {
		return available;
	}



	public void setAvailable(boolean available) {
		this.available = available;
	}



	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreation() {
		return creation;
	}

	public void setCreation(Date creation) {
		this.creation = creation;
	}

	public List<String> getOwner() {
		return owner;
	}

	public void setOwner(List<String> owner) {
		this.owner = owner;
	}
	
	
	
}
