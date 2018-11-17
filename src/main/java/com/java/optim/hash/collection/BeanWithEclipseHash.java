package com.java.optim.hash.collection;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BeanWithEclipseHash extends RootBean{

	
	public BeanWithEclipseHash() {}
	

	public BeanWithEclipseHash(int price, boolean available, String name, Date creation, List<String> owner) {
		super();
		this.price = price;
		this.available = available;
		this.name = name;
		this.creation = creation;
		this.owner = owner;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + price;
		return result;
	}


	
}
