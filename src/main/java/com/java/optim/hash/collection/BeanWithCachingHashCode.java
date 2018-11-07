package com.java.optim.hash.collection;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class BeanWithCachingHashCode {

	private final int price;
	private final boolean available;
	private final String name;
	private final Date creation;
	private final List<String> owner;
	private volatile int cachingHashCode =1;

	public BeanWithCachingHashCode(int price, boolean available, String name, Date creation,
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
		int result = cachingHashCode;
		if(cachingHashCode == 1) {
			final int prime = 31;
			result = prime * result + (available ? 1231 : 1237);
			result = prime * result + ((creation == null) ? 0 : creation.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			result = prime * result + ((owner == null) ? 0 : owner.hashCode());
			result = prime * result + price;
			cachingHashCode = result;
		}
		return result;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BeanWithCachingHashCode that = (BeanWithCachingHashCode) o;
		return price == that.price &&
				available == that.available &&
				cachingHashCode == that.cachingHashCode &&
				Objects.equals(name, that.name) &&
				Objects.equals(creation, that.creation) &&
				Objects.equals(owner, that.owner);
	}
}
