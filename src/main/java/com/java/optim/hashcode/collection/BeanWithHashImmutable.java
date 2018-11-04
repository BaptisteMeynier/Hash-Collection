package com.java.optim.hashcode.collection;

import java.util.Collections;
import java.util.Date;
import java.util.List;

public final class BeanWithHashImmutable {

	private final int price;//immutable
	private final boolean available;//immutable
	private final String name;//immutable
	private final Date creation;//mutable
	private final List<String> owner;//mutable
	
	public BeanWithHashImmutable(int price, boolean available, String name, Date creation, List<String> owner) {
		super();
		this.price = price;
		this.available = available;
		this.name = name;
		this.creation = creation;
		this.owner = owner;
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

	public boolean isAvailable() {
		return available;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (available ? 1231 : 1237);
		result = prime * result + ((creation == null) ? 0 : creation.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
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
		BeanWithHashImmutable other = (BeanWithHashImmutable) obj;
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
