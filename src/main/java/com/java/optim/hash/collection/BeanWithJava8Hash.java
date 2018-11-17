package com.java.optim.hash.collection;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BeanWithJava8Hash extends RootBean{

	
	public BeanWithJava8Hash() {}
	

	public BeanWithJava8Hash(int price, boolean available, String name, Date creation, List<String> owner) {
		super();
		this.price = price;
		this.available = available;
		this.name = name;
		this.creation = creation;
		this.owner = owner;
	}
	
	


	@Override
	public int hashCode() {
		return Objects.hash(price,available, name, creation, owner);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanWithJava8Hash other = (BeanWithJava8Hash) obj;
		if (available != other.available)
			return false;
		if (creation == null) {
			if (other.creation != null)
				return false;
		} else if (!creation.equals(other.creation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (price != other.price)
			return false;
		return true;
	}
	
}
