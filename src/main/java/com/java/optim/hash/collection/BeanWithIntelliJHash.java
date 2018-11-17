package com.java.optim.hash.collection;

import java.util.Date;
import java.util.List;

public class BeanWithIntelliJHash extends RootBean{

	
	public BeanWithIntelliJHash() {}
	

	public BeanWithIntelliJHash(int price, boolean available, String name, Date creation, List<String> owner) {
		super();
		this.price = price;
		this.available = available;
		this.name = name;
		this.creation = creation;
		this.owner = owner;
	}
	
	


	@Override
	public int hashCode() {
	    int result = (int) (price ^ (price >>> 32));
	    result = 31 * result + name.hashCode();
	    result = 31 * result + owner.hashCode();
	    result = 31 * result + creation.hashCode();
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
		BeanWithIntelliJHash other = (BeanWithIntelliJHash) obj;
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
