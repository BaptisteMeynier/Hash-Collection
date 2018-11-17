package com.java.optim.hash.collection;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class BeanWithPersonalizedHash extends RootBean{

	
	public BeanWithPersonalizedHash(int price, boolean available, String name, Date creation,
			List<String> owner) {
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

	public int getPrice() {
		return price;
	}


	public String getName() {
		return name;
	}


	public Date getCreation() {
		return new Date(creation.getTime());
	}


	public List<String> getOwner() {
		return Collections.unmodifiableList(owner);
	}

	@Override
	public int hashCode() {
		int result = 0;
		result = result + (available ? 22 : 44);
		result = result + ((creation == null) ? 0 : creation.hashCode());
		result = result + ((name == null) ? 0 : name.hashCode());
		result = result + ((owner == null) ? 0 : owner.hashCode());
		result = result + price; 
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanWithPersonalizedHash other = (BeanWithPersonalizedHash) obj;
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
