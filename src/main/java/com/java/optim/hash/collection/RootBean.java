package com.java.optim.hash.collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class RootBean implements Cloneable {

	protected int price;
	protected boolean available;
	protected String name;
	protected Date creation;
	protected List<String> owner;
	
	public int getPrice() {
		return price;
	}

	protected void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	public Date getCreation() {
		return creation;
	}

	protected void setCreation(Date creation) {
		this.creation = creation;
	}

	public List<String> getOwner() {
		return owner;
	}

	protected void setOwner(List<String> owner) {
		this.owner = owner;
	}

	public RootBean clone() {
		RootBean copy = new RootBean();
		copy.setPrice(this.price);
		copy.setName(this.name);
		copy.setCreation(new Date(this.creation.getTime()));
		copy.setOwner(new ArrayList(this.owner));
		return copy;
	}	
	
}
